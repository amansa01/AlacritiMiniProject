import {Component} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'Login',
  templateUrl: './mainpage.html',
  styleUrls: ['./mainpage.css']
})

export class MainPageComponent {

  constructor(private router: Router) {
  }
  public onClickLogout(){
    this.router.navigate(['']);
  }
  public onClickApplyLeave() {
    this.router.navigate(['/leaveapply']);
  };

  public onClickHistory() {
    this.router.navigate(['/history']);
  };

  public onClickCancel() {
    this.router.navigate(['/history']);
  };
}
