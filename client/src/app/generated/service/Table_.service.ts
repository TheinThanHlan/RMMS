
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Table_ } from '@bean/Table_';

@Injectable({
  providedIn: 'root'
})
export class Table_Service {

  constructor(private http: HttpClient) {
  }

  readTable_FromId(id: number): Observable<Table_> {
    return this.http.post<Table_>(AppConfigService.BASE_URL + "readTable_FromId", id);
  }
  readTable_(obj: Table_): Observable<Table_> {
    return this.http.post<Table_>(AppConfigService.BASE_URL + "readTable_", obj);
  }
  createTable_(obj: Table_) {
    return this.http.post<Table_>(AppConfigService.BASE_URL + "createTable_", obj)
  }
  updateTable_(obj: Table_) {
    return this.http.post<Table_>(AppConfigService.BASE_URL + "updateTable_", obj)
  }
  deleteTable_(id: number) {
    return this.http.post<boolean>(AppConfigService.BASE_URL + "deleteTable_", id);
  }
  readAllTable_s(id: number): Observable<Array<Table_>> {
    return this.http.post<Array<Table_>>(AppConfigService.BASE_URL + "readAllTable_s", id);
  }

}



