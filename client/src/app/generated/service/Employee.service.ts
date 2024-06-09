
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Employee } from '@bean/Employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) {
  }

  readEmployeeFromId(id: number): Observable<Employee> {
    return this.http.post<Employee>(AppConfigService.BASE_URL + "readEmployeeFromId", id);
  }
  readEmployee(obj: Employee): Observable<Employee> {
    return this.http.post<Employee>(AppConfigService.BASE_URL + "readEmployee", obj);
  }
  createEmployee(obj: Employee) {
    return this.http.post<Employee>(AppConfigService.BASE_URL + "createEmployee", obj)
  }
  updateEmployee(obj: Employee) {
    return this.http.post<Employee>(AppConfigService.BASE_URL + "updateEmployee", obj)
  }
  deleteEmployee(id: number) {
    return this.http.post<boolean>(AppConfigService.BASE_URL + "deleteEmployee", id);
  }
  readAllEmployees(id: number): Observable<Array<Employee>> {
    return this.http.post<Array<Employee>>(AppConfigService.BASE_URL + "readAllEmployees", id);
  }
}



