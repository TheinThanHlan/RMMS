
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { EmployeeSalary } from '@bean/EmployeeSalary';

@Injectable({
  providedIn: 'root'
})
export class EmployeeSalaryService {

  constructor(private http:HttpClient) {
  }

  readEmployeeSalaryFromId(id:number):Observable<EmployeeSalary>{
    return this.http.post<EmployeeSalary>(AppConfigService.BASE_URL+"readEmployeeSalaryFromId",id);
  }
  readEmployeeSalary(obj:EmployeeSalary):Observable<EmployeeSalary>{
    return this.http.post<EmployeeSalary>(AppConfigService.BASE_URL+"readEmployeeSalary",obj);
  }
  createEmployeeSalary(obj:EmployeeSalary){
    return this.http.post<EmployeeSalary>(AppConfigService.BASE_URL+"createEmployeeSalary",obj)
  }
  updateEmployeeSalary(obj:EmployeeSalary){
    return this.http.post<EmployeeSalary>(AppConfigService.BASE_URL+"updateEmployeeSalary",obj)
  }
  deleteEmployeeSalary(id:number){
    return this.http.post<boolean>(AppConfigService.BASE_URL+"deleteEmployeeSalary",id);
  }
}



