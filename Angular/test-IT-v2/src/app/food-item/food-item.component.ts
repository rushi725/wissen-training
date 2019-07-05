import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { isNgTemplate } from '@angular/compiler';

@Component({
  selector: 'app-food-item',
  templateUrl: './food-item.component.html',
  styleUrls: ['./food-item.component.css']
})
export class FoodItemComponent implements OnInit {
  currentTab = 1
  constructor() { }
  count=0;
  @Input() 
  value = "unknown";
  @Input("cartQty") cartQty;

  @Output() buy = new EventEmitter();

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


  handleBuy(event,add) {
    this.buy.emit({ item: this.value, add:add })
  }
}
