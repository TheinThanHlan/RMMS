import { Injectable } from '@angular/core';
import { MenuOrder } from '@bean/MenuOrder';
import { MenuOrderService } from '@service/MenuOrder.service';
import { VarsService } from '../vars/vars.service';

@Injectable({
  providedIn: 'root'
})
export class MenuOrderVarsService {

  private vouchers: Map<number, Map<number, MenuOrder>> = new Map<number, Map<number, MenuOrder>>();
  constructor(private menuOrderService: MenuOrderService, private vars: VarsService) { }
  public getMenuOrders(voucher_id: number): Map<number, MenuOrder> {
    return this.vouchers.get(voucher_id)!
  }

  public async fetchMenuOrders(voucher_id: number): Promise<boolean> {
    return await this.menuOrderService.readAllMenuOrders(voucher_id).toPromise().then((data) => {
      this.vouchers.set(voucher_id, new Map<number, MenuOrder>)
      if (data != null) {
        data.forEach((a) => {
          a.menu = this.vars.getMenus().get(a.menu.id)!
          this.vouchers.get(voucher_id)!.set(a.id, a)

        })
      }
      return true
    }).catch(() => {
      return false
    })
  }
}
