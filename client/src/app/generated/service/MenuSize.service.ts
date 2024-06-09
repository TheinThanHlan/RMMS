
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { MenuSize } from '@bean/MenuSize';

@Injectable({
  providedIn: 'root'
})
export class MenuSizeService {

  constructor(private http: HttpClient) {
  }

  readMenuSizeFromId(id: number): Observable<MenuSize> {
    return this.http.post<MenuSize>(AppConfigService.BASE_URL + "readMenuSizeFromId", id);
  }
  readMenuSize(obj: MenuSize): Observable<MenuSize> {
    return this.http.post<MenuSize>(AppConfigService.BASE_URL + "readMenuSize", obj);
  }
  createMenuSize(obj: MenuSize) {
    return this.http.post<MenuSize>(AppConfigService.BASE_URL + "createMenuSize", obj)
  }
  updateMenuSize(obj: MenuSize) {
    return this.http.post<MenuSize>(AppConfigService.BASE_URL + "updateMenuSize", obj)
  }
  deleteMenuSize(id: number) {
    return this.http.post<boolean>(AppConfigService.BASE_URL + "deleteMenuSize", id);
  }
  readAllMenuSizes(): Observable<MenuSize[]> {
    return this.http.post<MenuSize[]>(AppConfigService.BASE_URL + "readAllMenuSizes", "");
  }
}



