import { Component } from '@angular/core';
import { MenuOrder } from '@bean/MenuOrder';
import { MenuOrderVarsService } from '../../../../global/MenuOrderVars/menu-order-vars.service';
import { ActivatedRoute } from '@angular/router';
import { LoadingComponent } from '../../../../components/loading/loading.component';
import { VarsService } from '../../../../global/vars/vars.service';

@Component({
  selector: 'app-print-voucher',
  standalone: true,
  imports: [LoadingComponent],
  templateUrl: './print-voucher.component.html',
  styleUrl: './print-voucher.component.scss'
})
export class PrintVoucherComponent {
  public menuOrders: Map<number, MenuOrder> = new Map<number, MenuOrder>();
  public voucherId = 0;
  constructor(private menuOrderVars: MenuOrderVarsService,
    private activatedRoute: ActivatedRoute,
    private vars: VarsService
  ) {
    this.voucherId = Number.parseInt(activatedRoute.snapshot.paramMap.get("voucherId")!)

  }



  ngAfterViewInit() {
    print()
    //history.back()
  }

  filterMenuOrder() {
    let tmp = new Array<MenuOrder>()
    for (let a of this.menuOrderVars.getMenuOrders(this.voucherId).values()) {
      let isExist = false
      for (let b of tmp) {
        //if (a.menu.menuTemplate.name.toLowerCase().includes(this.filterMenu_Name_Voucher.toLowerCase())) {
        if (a.menu.id == b.menu.id) {
          isExist = true
          break;
        }
      }
      if (isExist == false) {
        tmp.push(a)
      }
    }
    return tmp
    // return this.menuOrderVars.getMenuOrders(this.voucherId).values();

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
    for (let a of this.menuOrderVars.getMenuOrders(this.voucherId).values()) {
      if (a.menu.id == menuId) {
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
  getTotal() {
    let total = 0;
    for (let a of this.menuOrderVars.getMenuOrders(this.voucherId).values()) {
      total += a.menu.menuPrices[0].price
    }

    return total
  }

}
