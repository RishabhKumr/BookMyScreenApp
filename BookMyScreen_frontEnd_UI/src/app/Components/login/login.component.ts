import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/Services/login.service';
import { TokenStorageService } from 'src/app/Services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  form: any = {
    username: null,
    password: null
  };
  isUser=false;
  isAdmin=true;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles:string="";
  
  constructor(private authService: LoginService, private tokenStorage: TokenStorageService,private router: Router) { }

  ngOnInit(): void {
  }




  onSubmit(): void {
    const { username, password } = this.form;
   console.log(username);
   console.log(password);
    this.authService.userLogin(username, password).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);
        console.log(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        
        this.roles = this.tokenStorage.getUser().roles;
        
        this.reloadPage();
        this.isUser = this.roles.includes('ROLE_USER');
        this.isAdmin = this.roles.includes('ROLE_ADMIN');
        if(this.isUser){
          this.reloadPage();
        this.router.navigate(['userdashboard']);
        }
        if(this.isAdmin){
          this.router.navigate(['admindashboard']);
        }
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }
  





  
  signUpMode(){
  const container = document.querySelector(".container-mobile");
  container.classList.add("sign-up-mode");
  }
  signInMode(){
  const container = document.querySelector(".container-mobile");
  container.classList.remove("sign-up-mode");
  }

}
