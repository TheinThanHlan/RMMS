
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { OrderType } from '@bean/OrderType';

@Injectable({
  providedIn: 'root'
})
export class OrderTypeService {

  constructor(private http: HttpClient) {
  }

  readOrderTypeFromId(id: number): Observable<OrderType> {
    return this.http.post<OrderType>(AppConfigService.BASE_URL + "readOrderTypeFromId", id);
  }
  readOrderType(obj: OrderType): Observable<OrderType> {
    return this.http.post<OrderType>(AppConfigService.BASE_URL + "readOrderType", obj);
  }
  createOrderType(obj: OrderType) {
    return this.http.post<OrderType>(AppConfigService.BASE_URL + "createOrderType", obj)
  }
  updateOrderType(obj: OrderType) {
    return this.http.post<OrderType>(AppConfigService.BASE_URL + "updateOrderType", obj)
  }
  deleteOrderType(id: number) {
    return this.http.post<boolean>(AppConfigService.BASE_URL + "deleteOrderType", id);
  }
  readAllOrderTypes() {
    return this.http.post<Array<OrderType>>(AppConfigService.BASE_URL + "readAllOrderTypes", 0);
  }
}



