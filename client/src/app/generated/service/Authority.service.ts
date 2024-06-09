
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Authority } from '@bean/Authority';

@Injectable({
  providedIn: 'root'
})
export class AuthorityService {

  constructor(private http:HttpClient) {
  }

  readAuthorityFromId(id:number):Observable<Authority>{
    return this.http.post<Authority>(AppConfigService.BASE_URL+"readAuthorityFromId",id);
  }
  readAuthority(obj:Authority):Observable<Authority>{
    return this.http.post<Authority>(AppConfigService.BASE_URL+"readAuthority",obj);
  }
  createAuthority(obj:Authority){
    return this.http.post<Authority>(AppConfigService.BASE_URL+"createAuthority",obj)
  }
  updateAuthority(obj:Authority){
    return this.http.post<Authority>(AppConfigService.BASE_URL+"updateAuthority",obj)
  }
  deleteAuthority(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteAuthority",id);
  }
}



