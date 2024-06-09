
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Page } from '@bean/Page';

@Injectable({
  providedIn: 'root'
})
export class PageService {

  constructor(private http:HttpClient) {
  }

  readPageFromId(id:number):Observable<Page>{
    return this.http.post<Page>(AppConfigService.BASE_URL+"readPageFromId",id);
  }
  readPage(obj:Page):Observable<Page>{
    return this.http.post<Page>(AppConfigService.BASE_URL+"readPage",obj);
  }
  createPage(obj:Page){
    return this.http.post<Page>(AppConfigService.BASE_URL+"createPage",obj)
  }
  updatePage(obj:Page){
    return this.http.post<Page>(AppConfigService.BASE_URL+"updatePage",obj)
  }
  deletePage(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deletePage",id);
  }
}



