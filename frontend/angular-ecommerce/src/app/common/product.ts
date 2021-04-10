export class Product {
    id: number = 0;
    sku: string = "";
    name: string = "";
    description: string = "";
    imageUrl: string = "";
    active: boolean = false;
    unitPrice: number = 0;
    unitsInStock: number = 0;
    dateCreated: Date = new Date;
    lastUpdated: Date = new Date;
}
