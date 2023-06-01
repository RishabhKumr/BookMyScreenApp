import { Component } from '@angular/core';
const sign_up_btn = document.getElementsByClassName("#sign-up-btn");
@Component({
selector: 'app-signup',
templateUrl: './signup.component.html',
styleUrls: ['./signup.component.css']
})
export class SignupComponent {

signUpMode(){
const container = document.querySelector(".container-mobile");
container.classList.add("sign-up-mode");
}
signInMode(){
const container = document.querySelector(".container-mobile");
container.classList.remove("sign-up-mode");
}
}