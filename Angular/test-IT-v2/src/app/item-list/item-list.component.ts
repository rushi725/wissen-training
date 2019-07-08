import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartService } from '../cart.service';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {


 //@Output() buy = new EventEmitter();
  cart = null;
  constructor(private cartService: CartService,private itemService:ItemService,private route: ActivatedRoute) { }

  items = [];

ngOnInit() {
  this.itemService.getItems().subscribe(e=>
    this.items = e);
  this.cart = this.cartService.getCart();
  this.cartService.getCartStream()
    .subscribe(e => {
      this.cart = e.cart;
    })
}



}
