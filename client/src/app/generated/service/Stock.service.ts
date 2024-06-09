
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Stock } from '@bean/Stock';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  constructor(private http:HttpClient) {
  }

  readStockFromId(id:number):Observable<Stock>{
    return this.http.post<Stock>(AppConfigService.BASE_URL+"readStockFromId",id);
  }
  readStock(obj:Stock):Observable<Stock>{
    return this.http.post<Stock>(AppConfigService.BASE_URL+"readStock",obj);
  }
  createStock(obj:Stock){
    return this.http.post<Stock>(AppConfigService.BASE_URL+"createStock",obj)
  }
  updateStock(obj:Stock){
    return this.http.post<Stock>(AppConfigService.BASE_URL+"updateStock",obj)
  }
  deleteStock(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteStock",id);
  }
}



