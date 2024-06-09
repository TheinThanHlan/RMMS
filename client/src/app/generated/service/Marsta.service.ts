
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Marsta } from '@bean/Marsta';

@Injectable({
  providedIn: 'root'
})
export class MarstaService {

  constructor(private http:HttpClient) {
  }

  readMarstaFromId(id:number):Observable<Marsta>{
    return this.http.post<Marsta>(AppConfigService.BASE_URL+"readMarstaFromId",id);
  }
  readMarsta(obj:Marsta):Observable<Marsta>{
    return this.http.post<Marsta>(AppConfigService.BASE_URL+"readMarsta",obj);
  }
  createMarsta(obj:Marsta){
    return this.http.post<Marsta>(AppConfigService.BASE_URL+"createMarsta",obj)
  }
  updateMarsta(obj:Marsta){
    return this.http.post<Marsta>(AppConfigService.BASE_URL+"updateMarsta",obj)
  }
  deleteMarsta(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteMarsta",id);
  }
}



