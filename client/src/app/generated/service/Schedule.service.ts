
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Schedule } from '@bean/Schedule';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  constructor(private http:HttpClient) {
  }

  readScheduleFromId(id:number):Observable<Schedule>{
    return this.http.post<Schedule>(AppConfigService.BASE_URL+"readScheduleFromId",id);
  }
  readSchedule(obj:Schedule):Observable<Schedule>{
    return this.http.post<Schedule>(AppConfigService.BASE_URL+"readSchedule",obj);
  }
  createSchedule(obj:Schedule){
    return this.http.post<Schedule>(AppConfigService.BASE_URL+"createSchedule",obj)
  }
  updateSchedule(obj:Schedule){
    return this.http.post<Schedule>(AppConfigService.BASE_URL+"updateSchedule",obj)
  }
  deleteSchedule(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteSchedule",id);
  }
}



