import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import apply = Reflect.apply;
import {LeaveApplyComponent} from './leave/leaveapply.component';
import {LeaveHistoryComponent} from './leave/leavehistory/leavehistory.component';
import {MainPageComponent} from './mainpage/mainpage.component';


const appRoutes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent, //canActivate[AuthGuard]
  },
  {
    path : 'leaveapply',
    component : LeaveApplyComponent

  },
  {
    path : 'history',
    component : LeaveHistoryComponent
  },
  {
    path : 'mainpage',
    component : MainPageComponent
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
