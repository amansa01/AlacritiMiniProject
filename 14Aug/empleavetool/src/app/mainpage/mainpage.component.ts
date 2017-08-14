import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../login/login.service';
import {EmpDetails} from '../register/empdetails.interface';

@Component({
  selector: 'main-page',
  templateUrl: './mainpage.html',
  styleUrls: ['./mainpage.css'],
  inputs: ['fName', 'lName', 'email:', 'contactNo', 'Gender']
})

export class MainPageComponent implements  OnInit{


  @Input('loginData1')loginData1: EmpDetails;

  ngOnInit(){   }

  constructor(private router: Router, private loginService: LoginService, private loginservice: LoginService ) {
  }
  public loginDataTest() {
    //
    // console.log('In Main Component ' + this.loginData1.email);
    console.log('In MAin ' + this.loginservice.LoginData.fName);
    }



public onClickLogout() {
      sessionStorage.clear();
    this.router.navigate(['']);
  }
  public onClickApplyLeave() {
    this.router.navigate(['/leaveapply']);
  };

  public onClickHistory() {
    this.router.navigate(['/history']);
  };

  public onClickCancel() {
    this.router.navigate(['/cancel']);
  };
}
