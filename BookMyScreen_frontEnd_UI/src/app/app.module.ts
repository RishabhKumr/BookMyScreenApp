import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HomeNavComponent } from './Components/home-nav/home-nav.component';
import { HomeComponent } from './Components/home/home.component';
import { LoginComponent } from './Components/login/login.component';
import { NgImageSliderComponent, NgImageSliderModule } from 'ng-image-slider';
import { FooterComponent } from './Components/footer/footer.component';

@NgModule({
declarations: [
AppComponent,
HomeNavComponent,
HomeComponent,
LoginComponent,
FooterComponent,
],
imports: [
BrowserModule,
AppRoutingModule,
HttpClientModule,
FormsModule,
NgImageSliderModule
],
providers: [],
bootstrap: [AppComponent]
})
export class AppModule { }