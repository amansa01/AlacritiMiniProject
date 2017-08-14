import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class LoginService {
  LoginData: any;
  constructor(private http: Http) {  }
  loginValues(loginData: any) {
    event.preventDefault();
   this.LoginData = this.http.post('http://localhost:8080/empLeaveTool-1/emp/login', loginData).toPromise();
   return this.LoginData;
    // return console.log(logindata);
  }
}
