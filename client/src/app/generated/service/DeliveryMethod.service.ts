
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { DeliveryMethod } from '@bean/DeliveryMethod';

@Injectable({
  providedIn: 'root'
})
export class DeliveryMethodService {

  constructor(private http:HttpClient) {
  }

  readDeliveryMethodFromId(id:number):Observable<DeliveryMethod>{
    return this.http.post<DeliveryMethod>(AppConfigService.BASE_URL+"readDeliveryMethodFromId",id);
  }
  readDeliveryMethod(obj:DeliveryMethod):Observable<DeliveryMethod>{
    return this.http.post<DeliveryMethod>(AppConfigService.BASE_URL+"readDeliveryMethod",obj);
  }
  createDeliveryMethod(obj:DeliveryMethod){
    return this.http.post<DeliveryMethod>(AppConfigService.BASE_URL+"createDeliveryMethod",obj)
  }
  updateDeliveryMethod(obj:DeliveryMethod){
    return this.http.post<DeliveryMethod>(AppConfigService.BASE_URL+"updateDeliveryMethod",obj)
  }
  deleteDeliveryMethod(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteDeliveryMethod",id);
  }
}



