
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Menu } from '@bean/Menu';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http: HttpClient) {
  }

  readMenuFromId(id: number): Observable<Menu> {
    return this.http.post<Menu>(AppConfigService.BASE_URL + "readMenuFromId", id);
  }
  readMenu(obj: Menu): Observable<Menu> {
    return this.http.post<Menu>(AppConfigService.BASE_URL + "readMenu", obj);
  }
  createMenu(obj: Menu) {
    return this.http.post<Menu>(AppConfigService.BASE_URL + "createMenu", obj)
  }
  updateMenu(obj: Menu) {
    return this.http.post<Menu>(AppConfigService.BASE_URL + "updateMenu", obj)
  }
  deleteMenu(id: number) {
    return this.http.post<boolean>(AppConfigService.BASE_URL + "deleteMenu", id);
  }
  readAllMenus(restaurantId: number) {
    return this.http.post<Array<Menu>>(AppConfigService.BASE_URL + "readAllMenus", restaurantId);
  }
}



