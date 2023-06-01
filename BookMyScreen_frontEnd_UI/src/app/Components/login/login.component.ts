import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
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
