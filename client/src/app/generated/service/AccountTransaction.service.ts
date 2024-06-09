
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { AccountTransaction } from '@bean/AccountTransaction';

@Injectable({
  providedIn: 'root'
})
export class AccountTransactionService {

  constructor(private http:HttpClient) {
  }

  readAccountTransactionFromId(id:number):Observable<AccountTransaction>{
    return this.http.post<AccountTransaction>(AppConfigService.BASE_URL+"readAccountTransactionFromId",id);
  }
  readAccountTransaction(obj:AccountTransaction):Observable<AccountTransaction>{
    return this.http.post<AccountTransaction>(AppConfigService.BASE_URL+"readAccountTransaction",obj);
  }
  createAccountTransaction(obj:AccountTransaction){
    return this.http.post<AccountTransaction>(AppConfigService.BASE_URL+"createAccountTransaction",obj)
  }
  updateAccountTransaction(obj:AccountTransaction){
    return this.http.post<AccountTransaction>(AppConfigService.BASE_URL+"updateAccountTransaction",obj)
  }
  deleteAccountTransaction(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteAccountTransaction",id);
  }
}



