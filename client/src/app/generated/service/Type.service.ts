
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Type } from '@bean/Type';

@Injectable({
  providedIn: 'root'
})
export class TypeService {

  constructor(private http: HttpClient) {
  }

  readTypeFromId(id: number): Observable<Type> {
    return this.http.post<Type>(AppConfigService.BASE_URL + "readTypeFromId", id);
  }
  readType(obj: Type): Observable<Type> {
    return this.http.post<Type>(AppConfigService.BASE_URL + "readType", obj);
  }
  createType(obj: Type) {
    return this.http.post<Type>(AppConfigService.BASE_URL + "createType", obj)
  }
  updateType(obj: Type) {
    return this.http.post<Type>(AppConfigService.BASE_URL + "updateType", obj)
  }
  deleteType(id: number) {
    return this.http.post<boolean>(AppConfigService.BASE_URL + "deleteType", id);
  }
  readAllTypes(): Observable<Array<Type>> {
    return this.http.post<Array<Type>>(AppConfigService.BASE_URL + "readAllTypes", 0);
  }
}


