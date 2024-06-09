
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '@service/app-config.service';
import { Observable } from 'rxjs';

import { Category } from '@bean/Category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) {
  }

  readCategoryFromId(id: number): Observable<Category> {
    return this.http.post<Category>(AppConfigService.BASE_URL + "readCategoryFromId", id);
  }
  readCategory(obj: Category): Observable<Category> {
    return this.http.post<Category>(AppConfigService.BASE_URL + "readCategory", obj);
  }
  createCategory(obj: Category) {
    return this.http.post<Category>(AppConfigService.BASE_URL + "createCategory", obj)
  }
  updateCategory(obj: Category) {
    return this.http.post<Category>(AppConfigService.BASE_URL + "updateCategory", obj)
  }
  deleteCategory(id: number) {
    return this.http.post<boolean>(AppConfigService.BASE_URL + "deleteCategory", id);
  }
  readAllCategories(typeId: number): Observable<Array<Category>> {
    return this.http.post<Array<Category>>(AppConfigService.BASE_URL + "readAllCategories", typeId);
  }
}



