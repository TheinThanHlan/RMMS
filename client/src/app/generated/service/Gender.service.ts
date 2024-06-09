
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Gender } from '@bean/Gender';

@Injectable({
  providedIn: 'root'
})
export class GenderService {

  constructor(private http:HttpClient) {
  }

  readGenderFromId(id:number):Observable<Gender>{
    return this.http.post<Gender>(AppConfigService.BASE_URL+"readGenderFromId",id);
  }
  readGender(obj:Gender):Observable<Gender>{
    return this.http.post<Gender>(AppConfigService.BASE_URL+"readGender",obj);
  }
  createGender(obj:Gender){
    return this.http.post<Gender>(AppConfigService.BASE_URL+"createGender",obj)
  }
  updateGender(obj:Gender){
    return this.http.post<Gender>(AppConfigService.BASE_URL+"updateGender",obj)
  }
  deleteGender(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteGender",id);
  }
}



