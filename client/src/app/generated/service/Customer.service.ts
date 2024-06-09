
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Customer } from '@bean/Customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) {
  }

  readCustomerFromId(id:number):Observable<Customer>{
    return this.http.post<Customer>(AppConfigService.BASE_URL+"readCustomerFromId",id);
  }
  readCustomer(obj:Customer):Observable<Customer>{
    return this.http.post<Customer>(AppConfigService.BASE_URL+"readCustomer",obj);
  }
  createCustomer(obj:Customer){
    return this.http.post<Customer>(AppConfigService.BASE_URL+"createCustomer",obj)
  }
  updateCustomer(obj:Customer){
    return this.http.post<Customer>(AppConfigService.BASE_URL+"updateCustomer",obj)
  }
  deleteCustomer(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteCustomer",id);
  }
}



