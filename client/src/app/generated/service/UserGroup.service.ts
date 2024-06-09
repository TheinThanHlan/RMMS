
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { UserGroup } from '@bean/UserGroup';

@Injectable({
  providedIn: 'root'
})
export class UserGroupService {

  constructor(private http: HttpClient) {
  }

  readUserGroupFromId(id: number): Observable<UserGroup> {
    return this.http.post<UserGroup>(AppConfigService.BASE_URL + "readUserGroupFromId", id);
  }
  readUserGroup(obj: UserGroup): Observable<UserGroup> {
    return this.http.post<UserGroup>(AppConfigService.BASE_URL + "readUserGroup", obj);
  }
  createUserGroup(obj: UserGroup) {
    return this.http.post<UserGroup>(AppConfigService.BASE_URL + "createUserGroup", obj)
  }
  updateUserGroup(obj: UserGroup) {
    return this.http.post<UserGroup>(AppConfigService.BASE_URL + "updateUserGroup", obj)
  }
  deleteUserGroup(id: number) {
    return this.http.post<boolean>(AppConfigService.BASE_URL + "deleteUserGroup", id);
  }

  readAllUserGroupsOfType(typeId: number) {
    return this.http.post<Array<UserGroup>>(AppConfigService.BASE_URL + "readAllUserGroupsOfType", typeId);
  }
}



