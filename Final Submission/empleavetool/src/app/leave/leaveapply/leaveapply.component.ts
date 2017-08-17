import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl, FormBuilder, Validators} from '@angular/forms';
import {LeaveModel} from '../leavemodel.interface';
import {LeaveApplyService} from './leaveapply.service';
import {Router} from "@angular/router";
import {LeaveTagComponent} from "../leavetag.component";
import {LoginService} from "../../login/login.service";


@Component({
  selector: 'leave-apply',
  templateUrl: './leaveapply.component.html',
  styleUrls: ['./leaveapply.css']
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
    toDate: new FormControl()
  });
  // tslint:disable-next-line:max-line-length
  constructor(private _fb: FormBuilder, private  leaveApplyService: LeaveApplyService, private router: Router, private loginService: LoginService) {
  }

  save(model: LeaveModel) {
    console.log(model);

    this.leaveApplyService.leaveApply(model).then((Response) => {
      console.log(Response);
      alert(Response.text());
    }).catch((error) => {
      console.log(error);
    });

    }
  public onClickLogout() {
    this.loginService.sessionClear();
    console.log('Session Clear Called');
    // window.sessionStorage.clear();
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

