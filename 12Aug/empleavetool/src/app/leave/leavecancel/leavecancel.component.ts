import {Component} from '@angular/core';
import {FormBuilder, FormControl, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {LeaveCancelService} from './leavecancelservice';
import {LeaveModel} from '../leavemodel.interface';


@Component({
  selector: 'leave-apply',
  templateUrl: './leavecancel.html',
  styleUrls: ['./leavecancel.css']
})


export class LeaveCancelComponent {
  Response: any;
  items: any;
  index= 0 ;
  public leaves: any[];
  public cancel = this._fb.group({
    empId: new FormControl('', [Validators.required, Validators.minLength(3)]),
  });

  constructor(private _fb: FormBuilder, private  leaveCancelService: LeaveCancelService, private router: Router) {
  }

  save(model: LeaveModel) {
    console.log(model);
    this.leaveCancelService.leaveCancel(model).then((response) => {
      console.log((response.json())) ;
          this.leaves = response.json();
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
        // this.leaveHistoryService.leaveHistory(model)
        //   .subscribe(resEmployeeData=>this.items=resEmployeeData,
    }
  onCancel(value: LeaveModel ) {

  console.log(value);


 this.leaveCancelService.onCancel(value).then((response) => {
   console.log((response.toString())) ;
 });

  }

  public onClickLogout() {
    window.sessionStorage.clear();
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


