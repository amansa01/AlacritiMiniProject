import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl, FormBuilder, Validators} from '@angular/forms';
import {LeaveModel} from './leavemodel.interface';
import {LeaveApplyService} from './leaveapply.service';
import {Router} from "@angular/router";
import {LeaveTagComponent} from "./leavetag.component";


@Component({
  selector: 'leave-apply',
  templateUrl: './leaveapply.component.html',
  styleUrls: ['./mainpage.css']
})

export class LeaveApplyComponent {
  Title = 'Aman';
  Response: any;
  public selectedTag: LeaveTagComponent = new LeaveTagComponent(2, 'Sick');
  leavetag = [
    new LeaveTagComponent(1, 'Casual' ),
    new LeaveTagComponent(2, 'Sick' ),
    new LeaveTagComponent(3, 'Emergency' ),
    new LeaveTagComponent(4, 'Home')
  ];

  public myForm = this._fb.group({
    empId: new FormControl('', [Validators.required, <any>Validators.minLength(3)]),
    fromDate: new FormControl(),
    reason: new FormControl('', <any>Validators.required),
    noDays: new FormControl(),
    leaveTag: new FormControl( Validators.maxLength(3)),
    // selectedTag: new FormControl(Validators.required),
    /* leaveStatus: new FormControl(),*/
   toDate: new FormControl()
  });

  constructor(private _fb: FormBuilder, private  leaveApplyService: LeaveApplyService, private router: Router) {
  }

  save(model: LeaveModel) {
    console.log(model);

    this.leaveApplyService.leaveApply(model).then((Response) => {
      console.log(Response);
    }).catch((error) => {
      console.log(error);
    });

    }
  public onClickLogout(){
    window.sessionStorage.clear();
    this.router.navigate(['']);
  }
  public onClickHistory() {
    this.router.navigate(['/history']);
}
  public onClickCancel() {
    this.router.navigate(['/cancel']);
  }
  public show() {
    console.log('show called');
  }

}

