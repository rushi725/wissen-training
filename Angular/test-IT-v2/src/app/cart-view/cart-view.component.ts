import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart-view',
  templateUrl: './cart-view.component.html',
  styleUrls: ['./cart-view.component.css']
})


export class CartViewComponent implements OnInit {
 // @Input("value") cart; 
 cart = null;
 cartItems = [];
 total=0;

  //@Output() buy = new EventEmitter();
  //visible=true;
  constructor(private cartService: CartService) { }

  ngOnInit() {
    console.log(this.cartItems.length===0)
    this.cart = this.cartService.getCart();
    this.cartItems = []
    this.cartItems = this.cart.keys();
    this.total = this.cartService.getTotal();
    this.cartService.getCartStream()
      .subscribe(e => {
        let { cart , total} = e;
        this.cart = cart;
        console.log(cart);
        this.cartItems = []
        this.cartItems = this.cart.keys();
        this.total = total;

      })
  }

  /*ngDoCheck() {
   
   this.cartItems = []
   this.cart = this.cartService.getCart();
   this.cartItems = this.cart.keys();
  }*/

  handleBuy(event,carts,add) {
    this.cartService.addToCart({ item: carts,add : add })
  }
}
