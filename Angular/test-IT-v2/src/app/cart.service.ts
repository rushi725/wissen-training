import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {


  cart = new Map();
  cartQty = 0;
  total=0;

  cartStream : Subject<any> = new  Subject();

  getCartStream() {
    return this.cartStream;
  }
  getCart() {
    return this.cart;
  }

  getTotal(){
    return this.total;
  }
  addToCart(event) {
    let { item,add } = event;
    let itemQty = this.cart.get(item);
    if (itemQty) {
      if(add){
        this.cart.set(item,itemQty + 1);
        this.total += item.price; 
      }
      else{
        this.cart.set(item,itemQty - 1);
        this.total -= item.price;
        if(this.cart.get(item)==0){
          this.cart.delete(item)
        }
      }
  
    } else {
      this.cart.set(item,1); 
      this.total += item.price;  
    }
    this.cartQty = this.cart.size;
    this.publishStream();
  }


  publishStream(){
    console.log(this.cart);
    this.cartStream.next({ cartQty: this.cartQty, cart: this.cart, total:this.total })
  }

  constructor() { }
}
