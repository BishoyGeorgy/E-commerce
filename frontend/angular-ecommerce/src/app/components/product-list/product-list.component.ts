import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/dto/product/product';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  currentCategoryId: number = 0;
  categoryName: string = 'All Products';
  keyword: string = '';

  constructor(private productService: ProductService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }

  listProducts() {
    // check if "id" parameter is available
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');
    const hasKeyword: boolean = this.route.snapshot.paramMap.has('keyword');

    if (hasCategoryId) {
      // get the "id" param string. convert string to a number using the "+" symbol
      this.currentCategoryId = +this.route.snapshot.paramMap.get('id')!;
      this.categoryName = this.route.snapshot.paramMap.get('name')!;

      this.productService.getProductByCategory(this.currentCategoryId).subscribe(
        data => {
          this.products = data;
        }
      )
    
    } else if (hasKeyword) {
      this.keyword = this.route.snapshot.paramMap.get('keyword')!;
      this.productService.getProductContaining(this.keyword).subscribe(
        data => {
          this.products = data;
        }
      )

    } else {
      this.productService.getProductsList().subscribe(
        data => {
          this.products = data;
        }
      )
    }
  }
}
