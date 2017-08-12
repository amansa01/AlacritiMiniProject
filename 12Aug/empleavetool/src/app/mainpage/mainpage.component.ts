import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from "../login/login.service";

@Component({
  selector: 'Login',
  templateUrl: './mainpage.html',
  styleUrls: ['./mainpage.css']
})

export class MainPageComponent {
  constructor(private router: Router, private loginService: LoginService ) {
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
