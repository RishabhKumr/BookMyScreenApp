import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-nav',
  templateUrl: './home-nav.component.html',
  styleUrls: ['./home-nav.component.css']
})
export class HomeNavComponent {
  @Input() city:string="Select Location";
  constructor(private router:Router){
  
  }
  ngOnInit(){
  this.city = sessionStorage.getItem('location');
  }
  navigateToLogin(){
  this.router.navigate(["login"]);
  }
  }