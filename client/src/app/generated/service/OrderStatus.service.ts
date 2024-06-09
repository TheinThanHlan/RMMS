
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { OrderStatus } from '@bean/OrderStatus';

@Injectable({
  providedIn: 'root'
})
export class OrderStatusService {

  constructor(private http:HttpClient) {
  }

  readOrderStatusFromId(id:number):Observable<OrderStatus>{
    return this.http.post<OrderStatus>(AppConfigService.BASE_URL+"readOrderStatusFromId",id);
  }
  readOrderStatus(obj:OrderStatus):Observable<OrderStatus>{
    return this.http.post<OrderStatus>(AppConfigService.BASE_URL+"readOrderStatus",obj);
  }
  createOrderStatus(obj:OrderStatus){
    return this.http.post<OrderStatus>(AppConfigService.BASE_URL+"createOrderStatus",obj)
  }
  updateOrderStatus(obj:OrderStatus){
    return this.http.post<OrderStatus>(AppConfigService.BASE_URL+"updateOrderStatus",obj)
  }
  deleteOrderStatus(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteOrderStatus",id);
  }
}



