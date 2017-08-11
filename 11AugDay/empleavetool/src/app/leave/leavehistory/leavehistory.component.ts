import {Component} from '@angular/core';
import {FormControl, FormBuilder, Validators} from '@angular/forms';

import {LeaveHistoryService} from './leavehistoryservice';
import {LeaveModel} from '../leavemodel.interface';
import {Router} from "@angular/router";


@Component({
  selector: 'leave-apply',
  templateUrl: './leavehistory.html',
  styleUrls: ['./leavehistory.css']
})

export class LeaveHistoryComponent {
  Title = 'Aman';
  Response: any;
  items: any;
  public history = this._fb.group({
    empId: new FormControl('', [Validators.required, Validators.minLength(3)]),
  });

  constructor(private _fb: FormBuilder, private  leaveHistoryService: LeaveHistoryService, private router: Router) {
  }

  save(model: LeaveModel) {
    console.log(model);

    this.leaveHistoryService.leaveHistory(model).then((Response) => {
      console.log(Response.json());
      console.log(Response.json().length)
      if (Response.json().length > 0) {
        this.items = Response.json();
          // this.router.navigate(['/mainpage']);
      } else {
        alert('Employee Does Not Exist');
        this.router.navigate(['/mainpage']);
      }
    }).catch((error) => {
      console.log(error);
    });
    // this.leaveHistoryService.leaveHistory(model)
    //   .subscribe(resEmployeeData=>this.items=resEmployeeData,
  }
}

