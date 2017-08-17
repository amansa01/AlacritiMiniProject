import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {Headers} from '@angular/http';

@Injectable()
export class DetailsService {
  public userDetails : any;
  constructor(private http: Http) {  }

  loginValues(loginData: any) {
    event.preventDefault();
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:8080/empLeaveTool-1/emp/login', loginData, { withCredentials: true}).toPromise();
     }


  setDetails(userDetails: any) {
      this.userDetails  = userDetails;
  }

  getDetails(){
    if(this.userDetails){
      return Promise.resolve(this.userDetails);
    } else {
      return Promise.reject('Not available');
    }
  }
}
