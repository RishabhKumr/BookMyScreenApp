import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegisterUser } from '../Entity/registerUser';
const api = "http://localhost:8086/auth/v1/";
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  isAuthenticate: boolean = false;

  requestHeader = new HttpHeaders({ "No-Auth": "True" });
  constructor(private httpClient:HttpClient) { }

  userLogin(username: string, password: string):Observable<any>{
    if(this.httpClient.post<any>(api+"login",{
      username,
      password
    }
    , httpOptions))
    {
      this.isAuthenticate=true;
      return this.httpClient.post<any>(api+"login",{
        username,
        password
      }
      , httpOptions);
    }
    else{
    return this.httpClient.post<any>(api+"login",{
      username,
      password
    }
    , httpOptions)
  }
  }
  register(register:RegisterUser): Observable<any> {
    return this.httpClient.post(api + 'signup', register, httpOptions);
  }
}