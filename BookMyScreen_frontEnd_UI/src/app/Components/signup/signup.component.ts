import { Component } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  signUpMode(){
    const container = document.querySelector(".container");
    container.classList.add("sign-up-mode");
    }
    signInMode(){
    const container = document.querySelector(".container");
    container.classList.remove("sign-up-mode");
    }
}
