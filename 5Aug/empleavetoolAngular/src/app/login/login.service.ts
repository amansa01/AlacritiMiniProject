import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

@Injectable()
export class LoginService{

    constructor(private http: Http) { }
      loginValues(logindata: any)
      {
         return this.http.post('http://localhost:8080/empLeaveTool-1/emp/login', logindata);
        // return console.log(logindata);
      }
}
