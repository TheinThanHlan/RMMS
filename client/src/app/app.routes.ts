import { Routes } from '@angular/router';
import { LoginComponent } from './pages/auth/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { SalesComponent } from './pages/home/sales/sales.component';
import { TablesComponent } from './pages/home/tables/tables.component';
import { EmployeesComponent } from './pages/home/employees/employees.component';
import { MenusComponent } from './pages/home/menus/menus.component';
import { OrdersComponent } from './pages/home/orders/orders.component';
import { authGuard } from './guards/auth/auth.guard';
import { CreateUserComponent } from './pages/tmp/create-user/create-user.component';
import { VoucherListComponent } from './pages/home/sales/voucher-list/voucher-list.component';
import { SalesDetailComponent } from './pages/home/sales/sales-detail/sales-detail.component';
import { VarsService } from './global/vars/vars.service';
import { PrintVoucherComponent } from './pages/home/sales/print-voucher/print-voucher.component';

const rootOutlet = "primary";
const homeOutlet = "homeOutlet"
const salesOutlet = "salesOutlet"

export const routes: Routes = [
  {
    path: "",
    pathMatch: 'full',
    outlet: rootOutlet,
    redirectTo: "auth/login"
  },

  {
    path: "auth",
    outlet: rootOutlet,
    children: [
      {
        path: 'login',
        pathMatch: 'full',
        component: LoginComponent,
      }
    ]
  },
  {
    path: "Admin",
    canActivate: [authGuard],
    children: [
      {
        path: "",
        redirectTo: "home",
        pathMatch: "full"
      },
      {

        path: "home",
        component: HomeComponent,
        outlet: rootOutlet,
        children: [
          {
            path: '',
            redirectTo: 'employees',
            outlet: homeOutlet,
            pathMatch: 'full'
          },
          { path: 'employees', component: EmployeesComponent, outlet: homeOutlet, pathMatch: 'full' },
        ]
      },
    ]
  },




  {
    path: "Manager",
    canActivate: [authGuard],
    children: [
      {
        path: "",
        redirectTo: "home",
        pathMatch: "full"
      },
      {

        path: "home",
        component: HomeComponent,
        outlet: rootOutlet,
        children: [
          {
            path: '',
            redirectTo: 'sales',
            outlet: homeOutlet,
            pathMatch: 'full'
          },
          {
            path: 'sales', component: SalesComponent, outlet: homeOutlet,
            children: [
              { path: '', component: VoucherListComponent, outlet: salesOutlet, pathMatch: 'full' },
              { path: 'salesDetail', component: SalesDetailComponent, outlet: salesOutlet, pathMatch: 'full' },
            ]
          },
          { path: 'tables', component: TablesComponent, outlet: homeOutlet, pathMatch: 'full' },
          { path: 'employees', component: EmployeesComponent, outlet: homeOutlet, pathMatch: 'full' },
          { path: 'menus', component: MenusComponent, outlet: homeOutlet, pathMatch: 'full' },
          { path: 'orders', component: OrdersComponent, outlet: homeOutlet, pathMatch: 'full' },

        ]
      },
    ]
  },





  {
    path: "tmp",
    outlet: rootOutlet,
    children: [
      { path: 'create-user', component: CreateUserComponent, pathMatch: 'full' },

    ]
  },
  {
    path: "print-voucher/:voucherId",
    outlet: rootOutlet,
    component: PrintVoucherComponent
  }
];
