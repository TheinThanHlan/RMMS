
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Account } from '@bean/Account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http:HttpClient) {
  }

  readAccountFromId(id:number):Observable<Account>{
    return this.http.post<Account>(AppConfigService.BASE_URL+"readAccountFromId",id);
  }
  readAccount(obj:Account):Observable<Account>{
    return this.http.post<Account>(AppConfigService.BASE_URL+"readAccount",obj);
  }
  createAccount(obj:Account){
    return this.http.post<Account>(AppConfigService.BASE_URL+"createAccount",obj)
  }
  updateAccount(obj:Account){
    return this.http.post<Account>(AppConfigService.BASE_URL+"updateAccount",obj)
  }
  deleteAccount(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteAccount",id);
  }
}



