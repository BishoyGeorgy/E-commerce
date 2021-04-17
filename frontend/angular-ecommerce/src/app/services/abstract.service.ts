import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AbstractService {

  static baseUrl = 'http://localhost:8080/api';
}
