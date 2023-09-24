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
import { SignupComponent } from './Components/signup/signup.component';
import { AdminComponent } from './Components/admin/admin.component';
import { AdvanceSearchComponent } from './Components/advance-search/advance-search.component';
import { WildcardComponent } from './Components/wildcard/wildcard.component';
import { UserDashboardComponent } from './Components/user/user-dashboard/user-dashboard.component';
import { UserProfileComponent } from './Components/user/user-profile/user-profile.component';
import { UserNavComponent } from './Components/user/user-nav/user-nav.component';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
@NgModule({
declarations: [
AppComponent,
HomeNavComponent,
HomeComponent,
LoginComponent,
FooterComponent,
SignupComponent,
AdminComponent,
AdvanceSearchComponent,
WildcardComponent,
UserDashboardComponent,
UserProfileComponent,
UserNavComponent
],
imports: [
BrowserModule,
AppRoutingModule,
HttpClientModule,
FormsModule,
NgImageSliderModule,
MDBBootstrapModule.forRoot(),
BrowserAnimationsModule,
],
providers: [],
bootstrap: [AppComponent],
schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule { }