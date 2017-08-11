import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl, FormBuilder, Validators} from '@angular/forms';
import {LeaveModel} from './leavemodel.interface';
import {LeaveApplyService} from './leaveapply.service';


@Component({
  selector: 'leave-apply',
  templateUrl: './leaveapply.component.html'
})

export class LeaveApplyComponent {
  Title = 'Aman';
  Response: any;
  public myForm = this._fb.group({
    empId: new FormControl('', [Validators.required, <any>Validators.minLength(3)]),
    fromDate: new FormControl(),
    reason: new FormControl('', <any>Validators.required),
    noDays: new FormControl(),
    leaveTag: new FormControl('', Validators.maxLength(3)),
   /* leaveStatus: new FormControl(),*/
   toDate: new FormControl()
  });

  constructor(private _fb: FormBuilder, private  leaveApplyService: LeaveApplyService) {
  }

  save(model: LeaveModel) {
    console.log(model);

    this.leaveApplyService.leaveApply(model).then((Response) => {
      console.log(Response.json());
    }).catch((error) => {
      console.log(error);
    });

    }
}

