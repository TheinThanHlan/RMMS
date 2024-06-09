import { Component, Input } from '@angular/core';
import { ActivatedRoute, PRIMARY_OUTLET, Router } from "@angular/router";
import { VarsService } from '../../../../global/vars/vars.service';
import { Voucher } from '@bean/Voucher';
import { VoucherService } from '@service/Voucher.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AddSomethingNewComponent } from '../../../../components/add-something-new/add-something-new.component';
import { catchError } from 'rxjs';
import { Category } from '@bean/Category';
import { Menu } from '@bean/Menu';
import { MenuTemplate } from '@bean/MenuTemplate';
import { MenuSize } from '@bean/MenuSize';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { OrderType } from '@bean/OrderType';
import { MenuOrderVarsService } from '../../../../global/MenuOrderVars/menu-order-vars.service';
import { MenuOrderService } from '@service/MenuOrder.service';
import { MenuOrder } from '@bean/MenuOrder';
import { State } from '@bean/State';
import { MenuPrice } from '@bean/MenuPrice';
import { VoucherVarsService } from '../../../../global/voucherVars/voucher-vars.service';
@Component({
  selector: 'app-sales-detail',
  standalone: true,
  imports: [CommonModule, FormsModule, AddSomethingNewComponent,
    MatFormFieldModule,
    MatInputModule,
    MatAutocompleteModule
  ],
  templateUrl: './sales-detail.component.html',
  styleUrl: './sales-detail.component.scss'
})
export class SalesDetailComponent {
  public voucherNumber!: number;
  add_order_modal_data = {
    name: "Add order",
    show: false,
    ERROR_MESSAGE: "",
    ok: "Add",
    cancel: "Cancel"
  }
  isDataLoaded = false
  choosedCategory: Category = new Category()
  choosedOrderType: OrderType = new OrderType()

  tmpMenuOrderObject = new MenuOrder();


  newCategoryObject: Category = new Category();
  newMenuTemplateObject: MenuTemplate = new MenuTemplate();
  constructor(
    private router: Router,
    public menuOrderService: MenuOrderService,
    public menuOrderVarsService: MenuOrderVarsService,
    private activatedRoute: ActivatedRoute,
    public vars: VarsService,
    private voucherService: VoucherService,
    public voucherVars: VoucherVarsService) {
    this.voucherNumber = Number.parseInt(this.activatedRoute.snapshot.paramMap.get("id")!)
    this.menuOrderVarsService.fetchMenuOrders(this.voucherNumber).then((data) => {
      if (data == true) {
        this.isDataLoaded = true
      }
    })
    this.tmpMenuOrderObject.voucher = new Voucher()
    this.tmpMenuOrderObject.voucher.id = this.voucherNumber
    this.resetAllData()
  }
  ngAfterViewInit() {
    this.choosedOrderType = this.vars.getOrderTypes().values().next().value
  }

  addOrder(menu: Menu) {
    let tmpOrder = new MenuOrder();
    tmpOrder.menu = new Menu();
    tmpOrder.orderState = new State()
    tmpOrder.voucher = new Voucher();
    tmpOrder.orderType = new OrderType()
    tmpOrder.menu.id = menu.id
    tmpOrder.voucher.id = this.voucherNumber
    tmpOrder.orderState.id = this.vars.getOrderStates().get("In queue")!.id
    tmpOrder.orderType.id = this.choosedOrderType.id
    this.menuOrderService.createMenuOrder(tmpOrder).subscribe((data) => {
      if (data != null) {
        data.menu = menu
        data.orderState = this.vars.getOrderStates().get("In queue")!
        data.orderType = this.choosedOrderType
        this.menuOrderVarsService.getMenuOrders(this.voucherNumber)!.set(data.id, data)
      }
    })
  }

  getTotal() {
    let total = 0;
    for (let a of this.menuOrderVarsService.getMenuOrders(this.voucherNumber).values()) {
      total += a.menu.menuPrices[0].price
    }

    return total
  }


  increaseMenuOrder(menuOrder: MenuOrder) {
    let tmpOrder = new MenuOrder();
    tmpOrder.menu = new Menu();
    tmpOrder.orderState = new State()
    tmpOrder.voucher = new Voucher();
    tmpOrder.orderType = new OrderType()
    tmpOrder.menu.id = menuOrder.menu.id
    tmpOrder.voucher.id = this.voucherNumber
    tmpOrder.orderState.id = this.vars.getOrderStates().get("In queue")!.id
    tmpOrder.orderType.id = menuOrder.orderType.id
    this.menuOrderService.createMenuOrder(tmpOrder).subscribe((data) => {
      if (data != null) {
        data.menu = menuOrder.menu
        data.orderState = this.vars.getOrderStates().get("In queue")!
        data.orderType = menuOrder.orderType
        this.menuOrderVarsService.getMenuOrders(this.voucherNumber)!.set(data.id, data)
      }
    })

  }
  decreaseMenuOrder(menuOrder: MenuOrder) {
    for (let a of this.menuOrderVarsService.getMenuOrders(this.voucherNumber).values()) {
      if (a.menu.id == menuOrder.menu.id && a.orderType.id == menuOrder.orderType.id && a.orderState.name == "In queue") {
        this.menuOrderService.deleteMenuOrder(a.id).subscribe((data) => {
          if (data == true) {
            this.menuOrderVarsService.getMenuOrders(this.voucherNumber).delete(a.id)
          }
        })
        break;
      }
    }
  }


  filterMenu_Name = ""
  filterMenu() {
    return [...this.vars.getMenus().values()].filter((data: Menu) => {
      if (this.choosedCategory.name != "" && this.filterMenu_Name != "") {
        return data.menuTemplate.category.id == this.choosedCategory.id && data.menuTemplate.name.toLowerCase().includes(this.filterMenu_Name.toLowerCase())
      }
      if (this.filterMenu_Name != "") {
        return data.menuTemplate.name.toLowerCase().includes(this.filterMenu_Name.toLowerCase())
      }
      if (this.choosedCategory.name != "") {
        return data.menuTemplate.category.id == this.choosedCategory.id
      }
      return true
    })
  }




  filterMenu_Name_Voucher = ""
  filterMenuOrder() {
    let tmp = new Array<MenuOrder>()
    for (let a of this.menuOrderVarsService.getMenuOrders(this.voucherNumber).values()) {
      let isExist = false
      for (let b of tmp) {
        //if (a.menu.menuTemplate.name.toLowerCase().includes(this.filterMenu_Name_Voucher.toLowerCase())) {
        if (a.menu.id == b.menu.id && a.orderType.id == b.orderType.id) {
          isExist = true
          break;
        }
      }
      if (isExist == false) {
        tmp.push(a)
      }
    }
    return tmp;

    /*
    return [...this.menuOrderVarsService.getMenuOrders(this.voucherNumber)!.values()].filter((data: MenuOrder, i, self) => {
      if (this.filterMenu_Name_Voucher != "") {
        return data.menu.menuTemplate.name.toLowerCase().includes(this.filterMenu_Name_Voucher.toLowerCase())
      }
      return true
    })
    */
  }

  countMenuOrder(menuId: number, orderTypeId: number) {
    let tmp = 0;
    for (let a of this.menuOrderVarsService.getMenuOrders(this.voucherNumber).values()) {
      if (a.menu.id == menuId && a.orderType.id == orderTypeId) {
        tmp += 1
      }
    }
    return tmp;

    /*
    return [...this.menuOrderVarsService.getMenuOrders(this.voucherNumber)!.values()].filter((data: MenuOrder, i, self) => {
      if (this.filterMenu_Name_Voucher != "") {
        return data.menu.menuTemplate.name.toLowerCase().includes(this.filterMenu_Name_Voucher.toLowerCase())
      }
      return true
    })
    */
  }



  newMenuSizeObject = new MenuSize()
  filterMenuSize() {
    let tmp = [...this.vars.getMenuSizes().values()].filter((a) => {
      /*     if (this.choosedMenu.menuTemplate.category != undefined) {
             return a.category.id == this.choosedMenu.menuTemplate.category.id
           }
           else {
             return false
           }*/
      return false
    })
    return tmp;
  }

  closeVoucher() {
    let tmp = new Voucher();
    tmp.id = this.voucherNumber
    tmp.state = new State();
    tmp.state.id = this.vars.getVoucherStates().get("Closed")!.id;



    this.voucherService.closeVoucher(tmp).subscribe((data) => {
      if (data == 1) {
        this.voucherVars.getVouchers().get(this.voucherNumber)!.state = this.vars.getVoucherStates().get("Closed")!
        localStorage.setItem("voucherDetailPage", this.router.url)
        this.router.navigate([{ outlets: { primary: ['print-voucher', this.voucherNumber] } }])
      }
    })
  }





  resetAllData() {
    this.choosedCategory = this.newCategoryObject
    this.newCategoryObject.name = ""
    this.newMenuTemplateObject.name = ""
  }
}
