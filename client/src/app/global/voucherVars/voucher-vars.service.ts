import { Injectable } from '@angular/core';
import { Voucher } from '@bean/Voucher';
import { VoucherService } from '@service/Voucher.service';
import { VarsService } from '../vars/vars.service';
import { State } from '@bean/State';
import { Restaurant } from '@bean/Restaurant';

@Injectable({
  providedIn: 'root'
})
export class VoucherVarsService {

  constructor(private vars: VarsService, private voucherService: VoucherService) { }


  private vouchers: Map<number, Voucher> = new Map<number, Voucher>();
  async loadVouchers(voucher: Voucher) {
    let tmp = new Voucher();
    tmp.state = new State();
    tmp.restaurant = new Restaurant();
    tmp.state.id = voucher.state.id
    tmp.rowCreatedDateTime = voucher.rowCreatedDateTime
    tmp.restaurant.id = this.vars.getCurrentRestaurant().id
    return await this.voucherService.readAllVouchers(tmp).toPromise().then((data) => {
      if (data != null) {
        data.forEach((a) => {
          this.vouchers.set(a.id, a)
        });
      }
      return true;
    }).catch(() => {
      return false;
    })
  }

  public async loadTodayVouchers() {
    let tmp = new Voucher();
    tmp.state = new State();
    tmp.restaurant = new Restaurant();
    tmp.state.id = 0
    tmp.rowCreatedDateTime = new Date()
    tmp.restaurant.id = this.vars.getCurrentRestaurant().id
    return await this.loadVouchers(tmp)
  }

  public getVouchers() {
    return this.vouchers;
  }




}
