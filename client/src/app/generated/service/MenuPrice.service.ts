
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { MenuPrice } from '@bean/MenuPrice';

@Injectable({
  providedIn: 'root'
})
export class MenuPriceService {

  constructor(private http:HttpClient) {
  }

  readMenuPriceFromId(id:number):Observable<MenuPrice>{
    return this.http.post<MenuPrice>(AppConfigService.BASE_URL+"readMenuPriceFromId",id);
  }
  readMenuPrice(obj:MenuPrice):Observable<MenuPrice>{
    return this.http.post<MenuPrice>(AppConfigService.BASE_URL+"readMenuPrice",obj);
  }
  createMenuPrice(obj:MenuPrice){
    return this.http.post<MenuPrice>(AppConfigService.BASE_URL+"createMenuPrice",obj)
  }
  updateMenuPrice(obj:MenuPrice){
    return this.http.post<MenuPrice>(AppConfigService.BASE_URL+"updateMenuPrice",obj)
  }
  deleteMenuPrice(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteMenuPrice",id);
  }
}



