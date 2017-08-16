import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {LeaveApplyComponent} from './leave/leaveapply/leaveapply.component';
import {LeaveHistoryComponent} from './leave/leavehistory/leavehistory.component';
import {MainPageComponent} from './mainpage/mainpage.component';
import {LeaveCancelComponent} from './leave/leavecancel/leavecancel.component';
import {AuthGuard} from './authguard';


const appRoutes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'cancel',
    component: LeaveCancelComponent
    },
  {
    path: 'register',
    component: RegisterComponent , canActivate: [ AuthGuard]
  },
  {
    path : 'leaveapply',
    component : LeaveApplyComponent , canActivate: [ AuthGuard]

  },
  {
    path : 'history',
    component : LeaveHistoryComponent , canActivate: [ AuthGuard]
  },
  {
    path : 'mainpage',
    component : MainPageComponent,
    data : { title: 'hi' }
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
