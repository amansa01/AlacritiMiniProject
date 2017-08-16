import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {LeaveModel} from '../leavemodel.interface';

@Injectable()
export class LeaveCancelService {

  constructor(private http: Http) {
  }

  leaveCancel(myForm: any) {
    event.preventDefault();
    return this.http.post('http://localhost:8080/empLeaveTool-1/leave/history', myForm).toPromise();
    // return console.log(logindata);
  }

  onCancel(model: LeaveModel) {
    event.preventDefault();
    return this.http.post('http://localhost:8080/empLeaveTool-1/leave/cancel', model).toPromise();

  }
}
