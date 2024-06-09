
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Voucher } from '@bean/Voucher';

@Injectable({
  providedIn: 'root'
})
export class VoucherService {

  constructor(private http: HttpClient) {
  }

  readVoucherFromId(id: number): Observable<Voucher> {
    return this.http.post<Voucher>(AppConfigService.BASE_URL + "readVoucherFromId", id);
  }
  readVoucher(obj: Voucher): Observable<Voucher> {
    return this.http.post<Voucher>(AppConfigService.BASE_URL + "readVoucher", obj);
  }
  createVoucher(obj: Voucher) {
    return this.http.post<Voucher>(AppConfigService.BASE_URL + "createVoucher", obj)
  }
  updateVoucher(obj: Voucher) {
    return this.http.post<Voucher>(AppConfigService.BASE_URL + "updateVoucher", obj)
  }
  deleteVoucher(id: number) {
    return this.http.post<boolean>(AppConfigService.BASE_URL + "deleteVoucher", id);
  }
  readTodayOpenedVouchers(id: number): Observable<Array<Voucher>> {
    return this.http.post<Array<Voucher>>(AppConfigService.BASE_URL + "readTodayOpenedVouchers", id);
  }


  //read the voucher that match with the given voucher Object
  readAllVouchers(voucher: Voucher): Observable<Array<Voucher>> {
    return this.http.post<Array<Voucher>>(AppConfigService.BASE_URL + "readAllVouchers", voucher);
  }

  closeVoucher(voucher: Voucher): Observable<number> {
    return this.http.post<number>(AppConfigService.BASE_URL + "closeVoucher", voucher);
  }
}



