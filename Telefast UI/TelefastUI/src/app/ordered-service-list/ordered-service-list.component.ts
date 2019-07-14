import { Component, OnInit } from '@angular/core';
import { OrderedServiceService } from '../ordered-service.service';

@Component({
  selector: 'app-ordered-service-list',
  templateUrl: './ordered-service-list.component.html',
  styleUrls: ['./ordered-service-list.component.scss']
})
export class OrderedServiceListComponent implements OnInit {

  constructor(private service:OrderedServiceService) { }
  orderedServices = []

  ngOnInit() {

    this.orderedServices = this.service.getOrderedServices();
    this.service.getStream().subscribe(e=>this.orderedServices.concat(e));
  }

}
