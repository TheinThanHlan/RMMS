
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { MenuOrder } from '@bean/MenuOrder';

@Injectable({
  providedIn: 'root'
})
export class MenuOrderService {

  constructor(private http: HttpClient) {
  }

  readMenuOrderFromId(id: number): Observable<MenuOrder> {
    return this.http.post<MenuOrder>(AppConfigService.BASE_URL + "readMenuOrderFromId", id);
  }
  readMenuOrder(obj: MenuOrder): Observable<MenuOrder> {
    return this.http.post<MenuOrder>(AppConfigService.BASE_URL + "readMenuOrder", obj);
  }
  createMenuOrder(obj: MenuOrder) {
    return this.http.post<MenuOrder>(AppConfigService.BASE_URL + "createMenuOrder", obj)
  }
  updateMenuOrder(obj: MenuOrder) {
    return this.http.post<MenuOrder>(AppConfigService.BASE_URL + "updateMenuOrder", obj)
  }
  deleteMenuOrder(id: number) {
    return this.http.post<boolean>(AppConfigService.BASE_URL + "deleteMenuOrder", id);
  }
  readAllMenuOrders(id: number): Observable<Array<MenuOrder>> {
    return this.http.post<Array<MenuOrder>>(AppConfigService.BASE_URL + "readAllMenuOrders", id);
  }
}



