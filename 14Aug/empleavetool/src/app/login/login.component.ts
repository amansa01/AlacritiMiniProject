import {Component} from '@angular/core';
import {LoginService} from './login.service';
import {Router} from '@angular/router';


@Component({
  selector: 'Login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  styles: [`input.ng-invalid {
    border-left: 5px solid red;
  }

  input.ng-valid {
    border-left: 5px solid green;
  }`]
})
export class LoginComponent {

  response: any;
 public loginData1: any;
  public gotResponse: any;
  constructor(private loginService: LoginService, private router: Router) {
  }

  onSubmit(value: any) {
        console.log(value);
      let loginData = {
      // 'empId': value.empid,
      'email': value.email,
      'passWord': value.password,
    };


    console.log(loginData);

    // this.response = false;

    // this.gotResponse = function(responseData: any){
    //   console.log("hoi there");
    //   return responseData;
    // }

    this.loginService.loginValues(loginData).then(( response: any ) => {
      console.log(response.json());
       if (response.json() ) {
         this.loginData1 = response.json();
         // this.loginData1 = response.json();
         console.log('In Login Component ' + this.loginData1.empId);
           this.router.navigate(['/mainpage']);
       }else {
        alert('Wrong Email or Password');
       }
       // this.gotResponse(response.json());
    }).catch((error: any) => {
      return console.log(error);
    });
  }
}
