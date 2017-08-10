import {Component} from '@angular/core';
import { FormControl, FormBuilder, Validators} from '@angular/forms';

import {LeaveHistoryService} from './leavehistoryservice';
import {LeaveModel} from '../leavemodel.interface';



@Component({
  selector: 'leave-apply',
  templateUrl: './leavehistory.html'
})

export class LeaveHistoryComponent  {
  Title = 'Aman';
  Response: any;
  public history = this._fb.group({
    empId: new FormControl('', [Validators.required, Validators.minLength(3)]),
    });

  constructor(private _fb: FormBuilder, private  leaveHistoryService: LeaveHistoryService) {
  }

  save(model: LeaveModel) {
    console.log(model);

    this.leaveHistoryService.leaveHistory(model).then((Response) => {
      console.log(Response.json());
    }).catch((error) => {
      console.log(error);
    });

  }
}

