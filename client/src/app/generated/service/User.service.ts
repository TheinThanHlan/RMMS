
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { User } from '@bean/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  readUserFromId(id: number): Observable<User> {
    return this.http.post<User>(AppConfigService.BASE_URL + "readUserFromId", id);
  }
  readUser(obj: User): Observable<User> {
    return this.http.post<User>(AppConfigService.BASE_URL + "readUser", obj);
  }
  createUser(obj: User) {
    return this.http.post<User>(AppConfigService.BASE_URL + "createUser", obj)
  }
  updateUser(obj: User) {
    return this.http.post<User>(AppConfigService.BASE_URL + "updateUser", obj)
  }
  deleteUser(id: number) {
    return this.http.post<boolean>(AppConfigService.BASE_URL + "deleteUser", id);
  }
  login(obj: User): Observable<User> {
    return this.http.post<User>(AppConfigService.BASE_URL + "login", obj);
  }
}



