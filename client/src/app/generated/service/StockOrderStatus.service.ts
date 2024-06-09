
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { StockOrderStatus } from '@bean/StockOrderStatus';

@Injectable({
  providedIn: 'root'
})
export class StockOrderStatusService {

  constructor(private http:HttpClient) {
  }

  readStockOrderStatusFromId(id:number):Observable<StockOrderStatus>{
    return this.http.post<StockOrderStatus>(AppConfigService.BASE_URL+"readStockOrderStatusFromId",id);
  }
  readStockOrderStatus(obj:StockOrderStatus):Observable<StockOrderStatus>{
    return this.http.post<StockOrderStatus>(AppConfigService.BASE_URL+"readStockOrderStatus",obj);
  }
  createStockOrderStatus(obj:StockOrderStatus){
    return this.http.post<StockOrderStatus>(AppConfigService.BASE_URL+"createStockOrderStatus",obj)
  }
  updateStockOrderStatus(obj:StockOrderStatus){
    return this.http.post<StockOrderStatus>(AppConfigService.BASE_URL+"updateStockOrderStatus",obj)
  }
  deleteStockOrderStatus(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteStockOrderStatus",id);
  }
}



