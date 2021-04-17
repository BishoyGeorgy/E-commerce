import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Category } from 'src/app/dto/category/category';
import { AbstractService } from '../abstract.service';

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  private baseUrl = AbstractService.baseUrl + '/categories';

  constructor(private httpClient: HttpClient) {}

  getCategoryList(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.baseUrl).pipe(
      map((response: Category[]) => {
        return response;
      })
    );
  }
}
