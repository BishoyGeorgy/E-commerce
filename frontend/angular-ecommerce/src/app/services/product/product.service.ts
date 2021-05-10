import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Product } from '../../dto/product/product';
import { AbstractService } from '../abstract.service';

@Injectable({
  providedIn: 'root',
})
export class ProductService {

  constructor(private httpClient: HttpClient) {}
  
  getProductsList(): Observable<Product[]> {
    const productsListURL = `${AbstractService.baseUrl}/products`;
    return this.httpClient
      .get<Product[]>(productsListURL)
      .pipe(map((response: Product[]) => response));
  }

  getProductByCategory(theCategoryId: number): Observable<Product[]> {
    const productURL = `${AbstractService.baseUrl}/products/${theCategoryId}`;

    return this.httpClient
      .get<Product[]>(productURL)
      .pipe(map((response: Product[]) => response));
  }

  getProductContaining(theKeyword: string): Observable<Product[]> {
    const searchUrl = `${AbstractService.baseUrl}/products/search?keyword=${theKeyword}`;

    return this.httpClient
      .get<Product[]>(searchUrl)
      .pipe(map((response: Product[]) => response));
  }
}