import { CommonModule } from '@angular/common';
import { ChangeDetectionStrategy, Component } from '@angular/core';
import { Router, RouterLink, UrlTree, RouterOutlet, ActivatedRoute, Route } from '@angular/router';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { VarsService } from '../../global/vars/vars.service';
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatIconModule, MatListModule, MatDividerModule, MatButtonModule, RouterOutlet, CommonModule, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  allDataLoaded = false
  route_dict: Map<String, Route> = new Map<String, Route>();
  constructor(public activatedRoute: ActivatedRoute, public vars: VarsService, public router: Router) {
    this.router.config.map((x) => {
      this.route_dict.set(x.path!.toString(), x)
    })
  }
  sideBarOpened = true
  public isDataLoaded = false
  ngAfterViewInit() {
    this.vars.loadAllNeccessaryData().then((data) => {
      this.isDataLoaded = true
    })
  }

  toggleSideBar() {
    this.sideBarOpened = !this.sideBarOpened
  }
  closeSideBar() {
    this.sideBarOpened = false
  }
  openSideBar() {
    this.sideBarOpened = true
  }
  ngOnInit() {
  }


}
