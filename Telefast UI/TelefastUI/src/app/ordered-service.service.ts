import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderedServiceService {

  constructor() { }

  orderedServices = [];

  stream: Subject<any> = new Subject();

  getStream() {
    return this.stream;
  }

  getOrderedServices() {
    return this.orderedServices;
  }


  addOrderedServices(service) {
      this.orderedServices.push(service);
      this.publishStream();
  }

  publishStream() {
    this.stream.next(e => {orderedServices: this.orderedServices; });
  }
}
