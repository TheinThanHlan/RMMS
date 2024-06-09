
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { PriorityLevel } from '@bean/PriorityLevel';

@Injectable({
  providedIn: 'root'
})
export class PriorityLevelService {

  constructor(private http:HttpClient) {
  }

  readPriorityLevelFromId(id:number):Observable<PriorityLevel>{
    return this.http.post<PriorityLevel>(AppConfigService.BASE_URL+"readPriorityLevelFromId",id);
  }
  readPriorityLevel(obj:PriorityLevel):Observable<PriorityLevel>{
    return this.http.post<PriorityLevel>(AppConfigService.BASE_URL+"readPriorityLevel",obj);
  }
  createPriorityLevel(obj:PriorityLevel){
    return this.http.post<PriorityLevel>(AppConfigService.BASE_URL+"createPriorityLevel",obj)
  }
  updatePriorityLevel(obj:PriorityLevel){
    return this.http.post<PriorityLevel>(AppConfigService.BASE_URL+"updatePriorityLevel",obj)
  }
  deletePriorityLevel(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deletePriorityLevel",id);
  }
}



