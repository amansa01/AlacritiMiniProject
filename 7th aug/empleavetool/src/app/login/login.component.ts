import { Component } from '@angular/core';
import {LoginService} from './login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'Login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  styles: [`input.ng-invalid{border-left:5px solid red;}
    input.ng-valid{border-left: 5px solid green;}`]
})
export class LoginComponent {

  response: any;

  constructor(private loginService: LoginService, private router: Router) {
  }

  onSubmit(value: any) {
    console.log(value);
    console.log('Login');
    let loginData = {
     // 'empId': value.empid,
      'email': value.email,
      'passWord': value.password,
    };
    console.log(loginData);
    this.loginService.loginValues(loginData).then((response) => {
      console.log(response.json());
    }).catch((error) => {
      console.log(error);
    });
  }
}
