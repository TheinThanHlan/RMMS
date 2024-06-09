import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {

  constructor() { }
  static BASE_URL = "http://192.168.99.136:8080/server/"
}
