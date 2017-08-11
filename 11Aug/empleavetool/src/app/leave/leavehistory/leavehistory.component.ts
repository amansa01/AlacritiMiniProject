import {Component} from '@angular/core';
import {FormControl, FormBuilder, Validators} from '@angular/forms';

import {LeaveHistoryService} from './leavehistoryservice';
import {LeaveModel} from '../leavemodel.interface';
import {Router} from '@angular/router';
import {DatePipe} from '@angular/common';


@Component({
  selector: 'leave-apply',
  templateUrl: './leavehistory.html',
  styleUrls: ['./leavehistory.css']
})

export class LeaveHistoryComponent {
  Title = 'Aman';
  Response: any;
  dateStr: any;
  items: any;
  private date: Date;
  tillDate: any;
  sdf: Date;
  public leaves: any[];

  public history = this._fb.group({
    empId: new FormControl('', [Validators.required, Validators.minLength(3)]),
  });

  constructor(private _fb: FormBuilder, private  leaveHistoryService: LeaveHistoryService, private router: Router) {
    this.date = new Date();

  }
  save(model: LeaveModel) {
    console.log(model);

    this.leaveHistoryService.leaveHistory(model).then((response) => {
      // console.log((response.json()[0].toDate).getMilliseconds());
      this.leaves = response.json();
      console.log('After to date');
      // if (response.json()[0].toDate.getMilliseconds() > this.date.getTime()) {
      //   console.log('Date');
      // }else {
      //   console.log('No Date');
      // };
      // console.log(this.date.getTime());
      console.log(response.json().length)
      if (response.json().length > 0) {
        this.items = response.json();
        // this.router.navigate(['/mainpage']);
      } else {
        alert('Employee Leave History Does Not Exist');
        this.router.navigate(['/mainpage']);
      }
    }).catch((error) => {
      console.log(error);
    });
    // this.leaveHistoryService.leaveHistory(model)
    //   .subscribe(resEmployeeData=>this.items=resEmployeeData,
  }

  public onClickLogout() {
    this.router.navigate(['']);
  }

  public onClickHistory() {
    this.router.navigate(['/history']);
  }

  public onClickCancel() {
    this.router.navigate(['/history']);
  }

  public onClickApplyLeave() {
    this.router.navigate(['/leaveapply']);
  }
}

