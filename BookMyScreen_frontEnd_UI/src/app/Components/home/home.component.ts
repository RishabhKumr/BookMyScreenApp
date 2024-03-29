import { Component, Input, ViewChild } from '@angular/core';
import { LocationService } from 'src/app/Services/location.service';
import { Observable } from 'rxjs';
import { Location } from 'src/app/Entity/Location'
import { NgImageSliderComponent } from 'ng-image-slider';
import { Movie } from 'src/app/Entity/Movie';
import { PreloginService } from 'src/app/Services/prelogin.service';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/Services/token-storage.service';
@Component({
selector: 'app-home',
templateUrl: './home.component.html',
styleUrls: ['./home.component.css']
})
export class HomeComponent {
location: Location | undefined;

private roles: string;
isLoggedIn = false;
showAdminBoard = false;
showModeratorBoard = false;
username?: string;
showGuest = false;

@Input() city: string = "";
constructor(private locationService: LocationService, private preLoginService: PreloginService,private tokenStorageService: TokenStorageService,private router:Router) {
}

// imageObject:Array<object>;
movie:Movie[] = [];

ngOnInit() {

  this.isLoggedIn = !!this.tokenStorageService.getToken();

  if (this.isLoggedIn) {
    const user = this.tokenStorageService.getUser();
    this.roles = user.roles;

    this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
    this.showModeratorBoard = this.roles.includes('ROLE_USER');

    if(this.showAdminBoard == true){
      this.router.navigate(['admindashboard']);
    }
    if(this.showModeratorBoard== true){
      this.router.navigate(['userdashboard']);
    }
    if(this.showModeratorBoard== false){
      this.router.navigate(['login']);
    }
    this.username = user.username;
  }

this.Repeat();
const promise = this.locationService.getLocation();
promise.subscribe((response) => {
this.location = response as Location;
console.log(this.location.city);
this.city = this.location.city;
sessionStorage.setItem("location", this.city);
});


// this.preLoginService.fetchMovies().subscribe((response) => {
//   this.imageObject = response;
//   console.log(this.imageObject);
// });

}
//image Slider by time
startIndex = 0;

ImageData = ["/assets/img1.jpg", "/assets/img_nature.jpg", "/assets/img_nature_wide.jpg"];
Repeat() {
setTimeout(() => {
this.__FunctionSlide();
this.Repeat();
}, 3000);
}

__FunctionSlide() {
const slides = Array.from(document.getElementsByClassName('mall-show-slide'));

for (const x of slides) {
  const y = x as HTMLElement;
  y.style.display = 'none';
}
if (this.startIndex > slides.length - 1) {
  this.startIndex = 0;
  const slide = slides[this.startIndex] as HTMLElement;
  slide.style.display = 'block';
  this.startIndex++;
} else {

  const slide = slides[this.startIndex] as HTMLElement;
  slide.style.display = 'block';
  this.startIndex++;
}
}
//ng-image-slider
@ViewChild('nav') slider: NgImageSliderComponent;


imageObject: Array<object> = [{
image: '/assets/img1.jpg',
thumbImage: '/assets/img1.jpg',
alt: 'alt of image',
title: 'title of image'
},
{
image: '/assets/img_nature_wide.jpg',
thumbImage: '/assets/img_nature_wide.jpg',
alt: 'alt of image',
title: 'title of image'
},
{
image: '/assets/img_nature_wide.jpg',
thumbImage: '/assets/img_nature_wide.jpg',
alt: 'alt of image',
title: 'title of image'
},
{
image: '/assets/img_nature_wide.jpg',
thumbImage: '/assets/img_nature_wide.jpg',
alt: 'alt of image',
title: 'title of image'
},
{
image: '/assets/img_nature_wide.jpg',
thumbImage: '/assets/img_nature_wide.jpg',
alt: 'alt of image',
title: 'title of image'
},
{
image: '/assets/img_nature_wide.jpg',
thumbImage: '/assets/img_nature_wide.jpg',
alt: 'alt of image',
title: 'title of image'
},
{
image: '/assets/img_nature_wide.jpg',
thumbImage: '/assets/img_nature_wide.jpg',
alt: 'alt of image',
title: 'title of image'
},
{
image: '/assets/img_nature_wide.jpg',
thumbImage: '/assets/img_nature_wide.jpg',
alt: 'alt of image',
title: 'title of image'
}];
prevImageClick() {
this.slider.prev();
}

nextImageClick() {
this.slider.next();
}
}