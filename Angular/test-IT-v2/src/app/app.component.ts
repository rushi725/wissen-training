import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Food Adda';
  cart = new Map();
  cartQty = 0;
  items = [{
    id :1,
    type : "Veg",
    name: "Veg Thali",
    imgPath:'assets/veg.jpg',
    price:200.00,
    canBuy:true,
    description: "veg is always cool"
  },
  {
    id :2,
    price:500,
    type: "Non Veg",
    name: "Chicken",
    imgPath:'assets/nonveg.jpg',
    canBuy:true,
    description: "nonveg is always cool"
  }
]


addToCart(event) {
  let { item,add } = event;
  let itemLine = this.cart.get(item);
  if (itemLine) {
    if(add)
      this.cart.set(item,itemLine + 1); 
    else{
      this.cart.set(item,itemLine - 1);
      if(this.cart.get(item)==0){
        this.cart.delete(item)
      }
    }

  } else {
    this.cart.set(item,1);  
  }
  this.cartQty = this.cart.size;
}
  
}
