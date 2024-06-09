//load neccessary data will call by the home component in this file
//if the loading is not success the site will not show
//

import { Injectable } from '@angular/core';
import { Component } from '@angular/core';
import { withInterceptors } from "@angular/common/http";
import { MenuSize } from "@bean/MenuSize";
import { Restaurant } from "@bean/Restaurant";
import { Table_ } from "@bean/Table_";
import { User } from "@bean/User"
import { MenuSizeService } from "@service/MenuSize.service";
import { MenuTemplate } from '@bean/MenuTemplate';
import { MenuTemplateService } from '@service/MenuTemplate.service';
import { MenuService } from '@service/Menu.service';
import { Menu } from '@bean/Menu';
import { Status } from '@bean/Status';
import { StateService } from '@service/State.service';
import { State } from '@bean/State';
import { Voucher } from '@bean/Voucher';
import { Table_Service } from '@service/Table_.service';
import { VoucherService } from "@service/Voucher.service";
import { TypeService } from '@service/Type.service';
import { Type } from '@bean/Type';
import { Category } from '@bean/Category';
import { CategoryService } from '@service/Category.service';
import { Resolve } from '@angular/router';
import { Observable, of } from 'rxjs';
import { UserGroupService } from '@service/UserGroup.service';
import { UserGroup } from '@bean/UserGroup';
import { Employee } from '@bean/Employee';
import { EmployeeService } from '@service/Employee.service';
import { OrderTypeService } from '@service/OrderType.service';
import { OrderType } from '@bean/OrderType';

@Injectable({
  providedIn: 'root'
})
export class VarsService {
  private x = true;



  constructor(private orderTypeService: OrderTypeService, private employeeService: EmployeeService, private userGroupService: UserGroupService, private categoryService: CategoryService, private typeService: TypeService, private voucherService: VoucherService, private tableService: Table_Service, private stateService: StateService, private menuService: MenuService, private menuSizeService: MenuSizeService, private menuTemplateService: MenuTemplateService) {
  }

  private USER_DICT_TOKEN: string = "user";
  private user!: User | null;
  private currentRestaurant: Restaurant = new Restaurant();
  private tables: Array<Table_> = [];

  private menuTemplates: Array<MenuTemplate> = new Array<MenuTemplate>();
  private menus: Map<number, Menu> = new Map<number, Menu>();


  public async loadAllNeccessaryData() {
    //load today opened vouchers
    await this.employeeService.readAllEmployees(this.getCurrentRestaurant().id).toPromise().then((data) => {
      if (data != null) {
        data.forEach((a) => {
          this.employees.set(a.id, a)
        })
      }
    })
    //load types
    await this.typeService.readAllTypes().toPromise().then((data) => {
      if (data != null) {
        for (let a of data) {
          this.types.set(a.name, a)
        }
      }
    });
    //load User groups
    await this.userGroupService.readAllUserGroupsOfType(this.getTypes().get("userGroup_employees")!.id!).toPromise().then((data) => {
      if (data != null) {
        for (let a of data) {
          this.employeeGroups.set(a.name, a)
        }
      }
    });

    //load menuCategories
    await this.categoryService.readAllCategories((this.getTypes().get("menu_category")!).id).toPromise().then((data) => {
      if (data != null) {
        for (let a of data) {
          this.menuCategories.set(a.name, a)
        }
      }
    })

    //load menu Template
    this.menuTemplateService.readAllMenuTemplates().subscribe((data) => {
      if (data != null) {
        this.menuTemplates = data
      }
    });
    //load menu sizes
    this.menuSizeService.readAllMenuSizes().subscribe((data) => {
      if (data != null) {
        data.forEach((a) => {
          this.menuSizes.set(a.id, a)
        })
      }
    })
    //load menus
    this.menuService.readAllMenus(this.getCurrentRestaurant().id).subscribe((data) => {
      if (data != null) {
        data.forEach((a) => {
          this.menus.set(a.id, a)

        })
      }
    })
    //load tables
    await this.tableService.readAllTable_s(this.getCurrentRestaurant().id).toPromise().then((data) => {
      if (data != null) {
        this.tables = data
      }
    })

    //load tableStates
    this.stateService.readAllStatesOfType(this.getTypes().get("table")!.id).subscribe((data) => {
      if (data != null) {
        this.tableStates = data
      }
    })
    //load Voucher States
    await this.stateService.readAllStatesOfType(this.getTypes().get("voucher")!.id).toPromise().then((data) => {
      if (data != null) {
        data.forEach((state) => {
          this.voucherStates.set(state.name, state)
        })
      }
    })
    //load Order States
    await this.stateService.readAllStatesOfType(this.getTypes().get("order_state")!.id).toPromise().then((data) => {
      if (data != null) {
        data.forEach((state) => {
          this.orderState.set(state.name, state)
        })
      }
    })

    await this.orderTypeService.readAllOrderTypes().toPromise().then((data) => {
      if (data != null) {
        data.forEach((a) => {
          this.orderTypes.set(a.id, a)
        })
      }
    })
    return true;
  }


  private orderTypes: Map<number, OrderType> = new Map<number, OrderType>()
  public getOrderTypes() {
    return this.orderTypes;
  }



  private menuCategories: Map<String, Category> = new Map<String, Category>();
  public getMenuCategories() {
    return this.menuCategories;
  }










  public getUser(): User | null {
    let tmp!: string | null;
    tmp = localStorage.getItem(this.USER_DICT_TOKEN);
    if (this.user == null) {
      if (tmp != null) {
        this.user = User.fromJson(JSON.parse(tmp));
      }
    }
    return this.user
  }

  public setUser(user: User | null): void {
    localStorage.setItem(this.USER_DICT_TOKEN, JSON.stringify(user));
    this.user = user;
  }
  public updateUser(): void {
    localStorage.setItem(this.USER_DICT_TOKEN, JSON.stringify(this.user));
  }


  public getCurrentRestaurant(): Restaurant {
    return this.currentRestaurant;
  }

  public setCurrentRestaurant(restaurant: Restaurant): void {
    let tmpRestaurant: Array<Restaurant> | null = this.getUser()!.restaurant;
    if (tmpRestaurant != null) {
      this.currentRestaurant = Restaurant.fromJson(tmpRestaurant.at(0) ?? {});
    }
  }

  public getCurrentRestaurantTable_s() {
    return this.tables;
  }
  addCurrentRestaurantTable_(table: Table_) {
    this.tables.push(table);
  }

  public removeCurrentRestaurantTable_(id: number) {
    let b = 0;
    for (let a of this.tables) {
      if (a.id == id) {
        this.tables.splice(b, 1)
      }
      b += 1;
    }
  }



  private menuSizes: Map<number, MenuSize> = new Map<number, MenuSize>()
  public getMenuSizes() {
    return this.menuSizes;
  }

  public getMenuTemplates(): Array<MenuTemplate> {
    return this.menuTemplates;
  }

  public addMenuTemplate(tmp: MenuTemplate) {
    this.menuTemplates.push(tmp);
  }

  public deleteMenuTemplate(id: number) {
    let b = 0;
    for (let a of this.menuTemplates) {
      if (a.id == id) {
        this.menuTemplates.splice(b, 1)
      }
      b += 1;
    }
  }


  public getMenus(): Map<number, Menu> {
    return this.menus;
  }
  public addMenu(tmp: Menu) {
    this.menus.set(tmp.id, tmp);
  }

  public deleteMenu(id: number) {
    this.menus.delete(id)
  }

  private types: Map<String, Type> = new Map<String, Type>();
  public getTypes() {
    return this.types
  }








  private tableStates: State[] = []
  public getTableStates() {
    return this.tableStates;
  }

  private orderState: Map<string, State> = new Map<string, State>()
  public getOrderStates() {
    return this.orderState;
  }

  private voucherStates: Map<string, State> = new Map<string, State>();
  public getVoucherStates() {
    return this.voucherStates;
  }



  private employeeGroups: Map<string, UserGroup> = new Map<string, UserGroup>();
  public getEmployeeGroups() {
    return this.employeeGroups;
  }

  private employees: Map<number, Employee> = new Map<number, Employee>();
  public getEmployees() {
    return this.employees;
  }


}
