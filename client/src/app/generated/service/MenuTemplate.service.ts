
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { MenuTemplate } from '@bean/MenuTemplate';

@Injectable({
  providedIn: 'root'
})
export class MenuTemplateService {

  constructor(private http: HttpClient) {
  }

  readMenuTemplateFromId(id: number): Observable<MenuTemplate> {
    return this.http.post<MenuTemplate>(AppConfigService.BASE_URL + "readMenuTemplateFromId", id);
  }
  readMenuTemplate(obj: MenuTemplate): Observable<MenuTemplate> {
    return this.http.post<MenuTemplate>(AppConfigService.BASE_URL + "readMenuTemplate", obj);
  }
  createMenuTemplate(obj: MenuTemplate) {
    return this.http.post<MenuTemplate>(AppConfigService.BASE_URL + "createMenuTemplate", obj)
  }
  updateMenuTemplate(obj: MenuTemplate) {
    return this.http.post<MenuTemplate>(AppConfigService.BASE_URL + "updateMenuTemplate", obj)
  }
  deleteMenuTemplate(id: number) {
    return this.http.post<boolean>(AppConfigService.BASE_URL + "deleteMenuTemplate", id);
  }
  readAllMenuTemplates(): Observable<MenuTemplate[]> {
    return this.http.post<MenuTemplate[]>(AppConfigService.BASE_URL + "readAllMenuTemplates", "");
  }
}



