import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class DetailsService {
  public userDetails : any;
  constructor(private http: Http) {  }

  loginValues(loginData: any) {
    event.preventDefault();
    return this.http.post('http://localhost:8080/empLeaveTool-1/emp/login', loginData).toPromise();
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
