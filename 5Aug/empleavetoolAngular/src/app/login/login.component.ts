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
export class LoginComponent  {

  response: any;
    constructor(private loginService: LoginService, private router: Router) {
    }
  /* onSubmit(value: any) {
     let loginData = {email : value.name, passWord : value.passWord , emp_id: value.emp_id}
      let json = JSON.stringify(loginData)
      let params = 'json=' + json;
      let headers = new Headers();
      headers.append('content-type', 'application/x-www-form-urlencoded');
      return this.http.post(' http://validate.jsontest.com ', params,{
        headers: headers
      })
        .map(res => {
          return res.json();
        });
    }
      /*
    let loginData = {
      'email': value.name,
      'passWord': value.password,
      'emp_id': value.emp_id
    };*/
      //console.log(loginData);
      /*this.loginService.loginValues(loginData).subscribe((response) => {
        console.log(response);
        if (response.status === 200){
          this.response = response.json();
          console.log(this.response);
          this.router.navigate(['/dashboard']);
        }
      });*/

}
