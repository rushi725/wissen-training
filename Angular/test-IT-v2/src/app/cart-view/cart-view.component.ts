import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-cart-view',
  templateUrl: './cart-view.component.html',
  styleUrls: ['./cart-view.component.css']
})


export class CartViewComponent implements OnInit {
  @Input("value") cart; 

  @Output() buy = new EventEmitter();
  cartItems = [];
  visible=true;
  constructor() { }

  ngOnInit() {
  }

  ngDoCheck() {
   
   this.cartItems = []
   this.cartItems = this.cart.keys();
   this.visible=false;
  }

  handleBuy(event,carts,add) {
    this.buy.emit({ item: carts,add : add })
  }
}
