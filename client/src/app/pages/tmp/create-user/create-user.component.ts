import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { Component } from '@angular/core';
import { UserService } from '@service/User.service';
import { User } from "@bean/User"
import { Restaurant } from '@bean/Restaurant';
import { RestaurantService } from '@service/Restaurant.service';
import { MenuSize } from '@bean/MenuSize';
import { MenuSizeService } from '@service/MenuSize.service';
import { State } from '@bean/State';
import { StateService } from '@service/State.service';
import { Table_Service } from '@service/Table_.service';
import { Table_ } from '@bean/Table_';
import { Type } from '@bean/Type';
import { TypeService } from '@service/Type.service';
import { Page } from '@bean/Page';
import { UserGroup } from '@bean/UserGroup';
import { UserGroupService } from '@service/UserGroup.service';
import { Employee } from '@bean/Employee';
import { EmployeeService } from '@service/Employee.service';
import { OrderType } from '@bean/OrderType';
import { OrderTypeService } from '@service/OrderType.service';
@Component({ selector: 'app-create-user',
    standalone: true,
    templateUrl: './create-user.component.html',
    styleUrl: './create-user.component.scss', imports: [], providers: [] })
export class CreateUserComponent {

  user: User = new User();
  restaurant: Restaurant = new Restaurant();
  constructor(private orderTypeService: OrderTypeService, private employeeService: EmployeeService, private userGroupService: UserGroupService, private typeService: TypeService, private table_Service: Table_Service, private stateService: StateService, private restaurantService: RestaurantService, private userService: UserService, private menuSizeService: MenuSizeService) { }
  async createUser() {

    let types = new Array<Type>()
    let typeNames = ["table", "voucher", "menu_category", "menu_subCategory", "userGroup_employees", "userGroup_customer", "order_state"]
    for (let a of typeNames) {
      let tmpType = new Type();
      tmpType.name = a
      types.push(tmpType)

    }
    for (let a = 0; a < types.length; a++) {
      await this.typeService.createType(types[a]).toPromise().then((data) => {
        if (data != null) {
          types[a] = data
        }
      });
    }

    let userGroups: Array<UserGroup> = new Array<UserGroup>();
    let userGroupNames = ["Admin", "Manager", "Cook"]
    for (let a of userGroupNames) {
      let tmp = new UserGroup();
      tmp.name = a;
      tmp.type = types.at(4)!
      await this.userGroupService.createUserGroup(tmp).toPromise().then((data) => {
        if (data != null) {
          userGroups.push(data)
        }
      })

    }



    this.restaurant.name = "OK";
    this.restaurant.email = "Ok@gmail.com";


    this.restaurantService.createRestaurant(this.restaurant).subscribe((data) => {

      this.restaurant = Restaurant.fromJson(data)
      this.user.loginableStatus = true;
      this.user.name = "Thein Than Hlan";
      this.user.userGroup = userGroups.at(0)!
      this.user.restaurant = [this.restaurant]
      this.userService.createUser(this.user).subscribe((data) => {
        if (data != null) {
          let tmpEmployee = new Employee();
          tmpEmployee.user = data;
          this.employeeService.createEmployee(tmpEmployee).subscribe()
        }
      });
    });
    /*
    let menuSizes: MenuSize[] = [];
    let menuSizeNames = ["small", "normal", "large"]
    for (let a of menuSizeNames) {
      let tmpMenuSize = new MenuSize()
      tmpMenuSize.name = a
      menuSizes.push(tmpMenuSize)
    }

    for (let a of menuSizes) {
      this.menuSizeService.createMenuSize(a).subscribe();
    }
    */

    let states: State[] = [];
    let stateNames: any = [
      ["Free", "text-success", types[0]],
      ["Serving", "text-danger", types[0]],
      ["Booked", "text-warning", types[0]],
      ["Not avaliable", "text-light", types[0]],
      ["Open", "text-success", types[1]],
      ["Closed", "text-warning", types[1]],
      ["Waiting", "text-warning", types[6]],
      ["Cooking", "text-info", types[6]],
      ["Cancled", "text-danger", types[6]],
      ["Cooked", "text-success", types[6]],
    ]
    for (let a of stateNames) {
      let tmpState = new State();
      tmpState.name = a[0]
      tmpState.guiClasses = a[1]
      tmpState.type = a[2]
      states.push(tmpState)
    }

    for (let a = 0; a < states.length; a++) {
      await this.stateService.createState(states[a]).toPromise().then((data) => {
        if (data != null) {
          states[a] = data
        }
      });
    }

    let table_: Table_ = new Table_();
    table_.restaurant = this.restaurant
    table_.state = states[0]
    for (let a = 0; a < 10; a++) {
      table_.name = a.toString()
      this.table_Service.createTable_(table_).subscribe();
    }


    let orderType: Array<OrderType> = new Array<OrderType>()
    let orderTypeNames = [
      ["စားမယ်", "text-success"],
      ["ပါဆယ်", "text-info"],


    ]
    for (let a of orderTypeNames) {
      let tmp = new OrderType()
      tmp.name = a[0]
      tmp.guiColor = a[1]
      await this.orderTypeService.createOrderType(tmp).toPromise().then((data) => {
        if (data != null) {
          orderType.push(data)
        }
      })
    }

  }
}
