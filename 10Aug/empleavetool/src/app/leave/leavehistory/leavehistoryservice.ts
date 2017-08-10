
import {Http} from '@angular/http';
import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class LeaveHistoryService {

  constructor(private http: Http) {  }

  leaveHistory(myForm: any) {
    event.preventDefault();
    return this.http.post('http://localhost:8080/empLeaveTool-1/leave/history', myForm).toPromise();
    // return console.log(logindata);
  }

}
