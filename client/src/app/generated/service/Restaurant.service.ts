
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Restaurant } from '@bean/Restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private http:HttpClient) {
  }

  readRestaurantFromId(id:number):Observable<Restaurant>{
    return this.http.post<Restaurant>(AppConfigService.BASE_URL+"readRestaurantFromId",id);
  }
  readRestaurant(obj:Restaurant):Observable<Restaurant>{
    return this.http.post<Restaurant>(AppConfigService.BASE_URL+"readRestaurant",obj);
  }
  createRestaurant(obj:Restaurant){
    return this.http.post<Restaurant>(AppConfigService.BASE_URL+"createRestaurant",obj)
  }
  updateRestaurant(obj:Restaurant){
    return this.http.post<Restaurant>(AppConfigService.BASE_URL+"updateRestaurant",obj)
  }
  deleteRestaurant(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteRestaurant",id);
  }
}



