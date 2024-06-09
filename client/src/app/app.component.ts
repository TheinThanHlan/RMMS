import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { MatSlideToggle } from "@angular/material/slide-toggle"
import { CommonModule } from '@angular/common';
import { UserService } from '@service/User.service';
import { User } from '@bean/User';
import { Restaurant } from '@bean/Restaurant';

import { JsonConvert } from 'json2typescript';
import { VarsService } from './global/vars/vars.service';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, MatSlideToggle],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'client';
}
