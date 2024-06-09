
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Delivery } from '@bean/Delivery';

@Injectable({
  providedIn: 'root'
})
export class DeliveryService {

  constructor(private http:HttpClient) {
  }

  readDeliveryFromId(id:number):Observable<Delivery>{
    return this.http.post<Delivery>(AppConfigService.BASE_URL+"readDeliveryFromId",id);
  }
  readDelivery(obj:Delivery):Observable<Delivery>{
    return this.http.post<Delivery>(AppConfigService.BASE_URL+"readDelivery",obj);
  }
  createDelivery(obj:Delivery){
    return this.http.post<Delivery>(AppConfigService.BASE_URL+"createDelivery",obj)
  }
  updateDelivery(obj:Delivery){
    return this.http.post<Delivery>(AppConfigService.BASE_URL+"updateDelivery",obj)
  }
  deleteDelivery(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteDelivery",id);
  }
}



