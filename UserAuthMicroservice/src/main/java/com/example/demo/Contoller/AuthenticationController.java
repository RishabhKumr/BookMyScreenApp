package com.example.demo.Contoller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RequestMapping("auth/v1")
@RestController
@CrossOrigin(origins = "*",allowedHeaders="*")
public class AuthenticationController
{

private Map<String,String> mapObj = new HashMap<String,String>();

@Autowired
private UserService userService;


@PostMapping("/addUser")
public ResponseEntity<?> registerUser(@RequestBody User user)
{
    if(userService.addUser(user)!=null)
    {
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
    return new ResponseEntity<String>("User not registered", HttpStatus.CONFLICT);
}


public String generateToken(String username, String password) throws ServletException, Exception
{
    String jwtToken;
    
    if(username==null || password == null)
    {
        throw new ServletException("Please enter valid username and password");
    }
    
    boolean flag= userService.loginUser(username, password);
    
    if(!flag)
    {
        throw new ServletException("Invalid credentials");
        
    }
    else
    {
        jwtToken= Jwts.builder().setSubject(username).setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis()+ 3000000))
                    .signWith(SignatureAlgorithm.HS256, "secret key").compact();
    }
    
    return jwtToken;
}

@PostMapping("/login")
public ResponseEntity<?> performLogin(@RequestBody User user)
{
    try
    {
        String jwtToken = generateToken(user.getUsername(), user.getPassword());
        mapObj.put("message", "User successfully logged in");
        mapObj.put("jwtToken", jwtToken);
        
    }
    catch(Exception e)
    {
        mapObj.put("message", "User not logged in");
        mapObj.put("jwtToken", null);
    }
    
    return new ResponseEntity<>(mapObj, HttpStatus.CREATED);
}
}

