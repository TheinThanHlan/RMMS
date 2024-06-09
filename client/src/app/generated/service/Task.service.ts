
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Task } from '@bean/Task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http:HttpClient) {
  }

  readTaskFromId(id:number):Observable<Task>{
    return this.http.post<Task>(AppConfigService.BASE_URL+"readTaskFromId",id);
  }
  readTask(obj:Task):Observable<Task>{
    return this.http.post<Task>(AppConfigService.BASE_URL+"readTask",obj);
  }
  createTask(obj:Task){
    return this.http.post<Task>(AppConfigService.BASE_URL+"createTask",obj)
  }
  updateTask(obj:Task){
    return this.http.post<Task>(AppConfigService.BASE_URL+"updateTask",obj)
  }
  deleteTask(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteTask",id);
  }
}



