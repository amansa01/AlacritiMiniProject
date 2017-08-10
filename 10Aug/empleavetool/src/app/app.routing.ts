import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import apply = Reflect.apply;
import {LeaveApplyComponent} from "./leave/leaveapply.component";
import {LeaveHistoryComponent} from "./leave/leavehistory/leavehistory.component";


const appRoutes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path : 'leaveapply',
    component : LeaveApplyComponent

  },
  {
    path : 'history',
    component : LeaveHistoryComponent
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
