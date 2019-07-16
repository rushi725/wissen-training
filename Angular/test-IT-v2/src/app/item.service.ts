import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private _http: HttpClient) { }

//   items = [{
//     id :1,
//     type : "Veg",
//     name: "Veg Thali",
//     imgPath:'assets/veg.jpg',
//     price:200.00,
//     canBuy:true,
//     description: "veg is always cool"
//   },
//   {
//     id :2,
//     price:500,
//     type: "Non Veg",
//     name: "Chicken",
//     imgPath:'assets/nonveg.jpg',
//     canBuy:true,
//     description: "nonveg is always cool"
//   }
// ]


getItems() {
  let api = "http://localhost:8081/api/v1/items"
  return this._http.get(api);
  //return this.items;
}
getReviews(id) {
  return [
    { author: 'who@mail.com', stars: 5, body: 'sample-review-1' },
    { author: 'who@mail.com', stars: 2, body: 'sample-review-2' }
  ]
}
}
