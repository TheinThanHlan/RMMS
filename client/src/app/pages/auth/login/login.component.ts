import { Component } from '@angular/core';
import { FormControl, Validators, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { User } from '@bean/User';
import { withFetch } from '@angular/common/http';
import { UserService } from '@service/User.service';
import { Router } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { VarsService } from '../../../global/vars/vars.service';



@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  user: User = new User();
  SWW_ERR_MESSAGE = "Something went wrong";
  show_SWW_ERR = false
  c = console.log

  constructor(public vars: VarsService, private userService: UserService, private router: Router) { }




  login() {
    if (this.user.password != null) {
      this.userService.login(this.user).subscribe((data) => {
        if (data != null) {
          this.vars.setUser(User.fromJson(data))
          this.show_SWW_ERR = false
          this.router.navigate([data.userGroup.name])
        } else {
          this.show_SWW_ERR = true
        }
      });
    }
    else {
      this.show_SWW_ERR = true;
    }
  }
}
