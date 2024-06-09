
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { StockOrder } from '@bean/StockOrder';

@Injectable({
  providedIn: 'root'
})
export class StockOrderService {

  constructor(private http:HttpClient) {
  }

  readStockOrderFromId(id:number):Observable<StockOrder>{
    return this.http.post<StockOrder>(AppConfigService.BASE_URL+"readStockOrderFromId",id);
  }
  readStockOrder(obj:StockOrder):Observable<StockOrder>{
    return this.http.post<StockOrder>(AppConfigService.BASE_URL+"readStockOrder",obj);
  }
  createStockOrder(obj:StockOrder){
    return this.http.post<StockOrder>(AppConfigService.BASE_URL+"createStockOrder",obj)
  }
  updateStockOrder(obj:StockOrder){
    return this.http.post<StockOrder>(AppConfigService.BASE_URL+"updateStockOrder",obj)
  }
  deleteStockOrder(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteStockOrder",id);
  }
}



