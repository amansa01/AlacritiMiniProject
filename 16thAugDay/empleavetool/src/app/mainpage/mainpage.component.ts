import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../login/login.service';
import {EmpDetails} from '../register/empdetails.interface';
import {DetailsService} from "../details.service";

@Component({
  selector: 'main-page',
  templateUrl: './mainpage.html',
  styleUrls: ['./mainpage.css'],
  inputs: ['fName', 'lName', 'email:', 'contactNo', 'Gender']
})

export class MainPageComponent implements  OnInit{

  public userDetails : any;
  @Input('loginData1')loginData1: EmpDetails;



  constructor(private router: Router, private loginService: LoginService, private loginservice: LoginService,
              private detailsService: DetailsService) {
              }
  public loginDataTest() {
    console.log('In MAin ' + this.loginservice.LoginData.fName);
    }


  ngOnInit() {
    this.detailsService.getDetails().then((details) => {
      this.userDetails = details;
    }).catch((error) => {
      console.log(error);
    });
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
