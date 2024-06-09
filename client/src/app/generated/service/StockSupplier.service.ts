
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { StockSupplier } from '@bean/StockSupplier';

@Injectable({
  providedIn: 'root'
})
export class StockSupplierService {

  constructor(private http:HttpClient) {
  }

  readStockSupplierFromId(id:number):Observable<StockSupplier>{
    return this.http.post<StockSupplier>(AppConfigService.BASE_URL+"readStockSupplierFromId",id);
  }
  readStockSupplier(obj:StockSupplier):Observable<StockSupplier>{
    return this.http.post<StockSupplier>(AppConfigService.BASE_URL+"readStockSupplier",obj);
  }
  createStockSupplier(obj:StockSupplier){
    return this.http.post<StockSupplier>(AppConfigService.BASE_URL+"createStockSupplier",obj)
  }
  updateStockSupplier(obj:StockSupplier){
    return this.http.post<StockSupplier>(AppConfigService.BASE_URL+"updateStockSupplier",obj)
  }
  deleteStockSupplier(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteStockSupplier",id);
  }
}



