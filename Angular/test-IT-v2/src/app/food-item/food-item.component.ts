import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { isNgTemplate } from '@angular/compiler';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-food-item',
  templateUrl: './food-item.component.html',
  styleUrls: ['./food-item.component.css']
})
export class FoodItemComponent implements OnInit {
  currentTab = 1
  count=0;
  @Input("value") item;
  @Input("cartQty") cartQt;

  //@Output() buy = new EventEmitter();

  reviews = [
    {author:"angel priya", stars:4,body:"worst"},
    {author:"angel priya", stars:4,body:"worst"}
  ]

  ngOnInit() {
  }
  isTabSelected(tabIndex) {
    return this.currentTab === tabIndex;
  }
  changeTab(event, tabIndex) {
    event.preventDefault();
    this.currentTab = tabIndex;
  }

  incementCount(event) {
    //console.dir(event)
    this.count++;
    //this.boom.emit({ value: (Number.parseInt(this.value, 10)) * this.count })
  }
  constructor(private cartService: CartService) { }

  handleBuy(event) {
    //this.buy.emit({ item: this.value, add:add })
    this.cartService.addToCart({item:this.item,add:true})
  }
}
