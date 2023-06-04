import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Components/home/home.component';
import { LoginComponent } from './Components/login/login.component';
import { SignupComponent } from './Components/signup/signup.component';
import { AdvanceSearchComponent } from './Components/advance-search/advance-search.component';
import { WildcardComponent } from './Components/wildcard/wildcard.component';
import { UserDashboardComponent } from './Components/user/user-dashboard/user-dashboard.component';
import { AdminComponent } from './Components/admin/admin.component';

const routes: Routes = [
  {
  path:"",component:HomeComponent
  },
  {
  path:"login",component:LoginComponent
  },
  {
  path:"signup",component:SignupComponent
  },
  {
  path:"advancesearch",component:AdvanceSearchComponent
  },
  {
    path:"userdashboard",component:UserDashboardComponent
  },
  {
    path:"admindashboard",component:AdminComponent
  },
  {
  path:"**",component:WildcardComponent
  }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
