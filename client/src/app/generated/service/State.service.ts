
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { State } from '@bean/State';

@Injectable({
  providedIn: 'root'
})
export class StateService {

  constructor(private http: HttpClient) {
  }

  readStateFromId(id: number): Observable<State> {
    return this.http.post<State>(AppConfigService.BASE_URL + "readStateFromId", id);
  }
  readState(obj: State): Observable<State> {
    return this.http.post<State>(AppConfigService.BASE_URL + "readState", obj);
  }
  createState(obj: State) {
    return this.http.post<State>(AppConfigService.BASE_URL + "createState", obj)
  }
  updateState(obj: State) {
    return this.http.post<State>(AppConfigService.BASE_URL + "updateState", obj)
  }
  deleteState(id: number) {
    return this.http.post<boolean>(AppConfigService.BASE_URL + "deleteState", id);
  }
  readAllStatesOfType(typeId: number): Observable<Array<State>> {
    return this.http.post<Array<State>>(AppConfigService.BASE_URL + "readAllStatesOfType", typeId);
  }
}



