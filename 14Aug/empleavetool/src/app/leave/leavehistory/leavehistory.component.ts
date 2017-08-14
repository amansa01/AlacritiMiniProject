import {Component} from '@angular/core';
import {FormControl, FormBuilder, Validators} from '@angular/forms';

import {LeaveHistoryService} from './leavehistoryservice';
import {LeaveModel} from '../leavemodel.interface';
import {Router} from '@angular/router';

@Component({
  selector: 'leave-apply',
  templateUrl: './leavehistory.html',
  styleUrls: ['./leavehistory.css']
})

export class LeaveHistoryComponent {
  Title = 'Aman';
   items: any;
  private date: Date;
  public leaves: any[];

  public history = this._fb.group({
    empId: new FormControl('', [Validators.required, Validators.minLength(3)]),
  });

  constructor(private _fb: FormBuilder, private  leaveHistoryService: LeaveHistoryService, private router: Router) {
    this.date = new Date();

  }
  save(model: LeaveModel) {
    // console.log(model);

    this.leaveHistoryService.leaveHistory(model).then((response) => {
      console.log((response.json()));

      console.log(response.json().length);
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
  }

  public onClickLogout() {
    sessionStorage.clear();
    this.router.navigate(['']);
  }

  public onClickHistory() {
    this.router.navigate(['/history']);
  }

  public onClickCancel() {
    this.router.navigate(['/cancel']);
  }

  public onClickApplyLeave() {
    this.router.navigate(['/leaveapply']);
  }
}
