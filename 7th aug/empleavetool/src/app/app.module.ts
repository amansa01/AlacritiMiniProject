import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';

import { AppComponent }  from './app.component';
import {LoginComponent} from './login/login.component';
import {FormsModule} from '@angular/forms';
import {RegisterComponent} from './register/register.component';
import {routing} from './app.routing';
import {LoginService} from './login/login.service';
import {RegisterService} from './register/register.service';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  declarations: [ AppComponent, LoginComponent, RegisterComponent ],
  providers: [LoginService, RegisterService],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
