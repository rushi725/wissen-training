import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.scss'],
  // changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ServiceListComponent implements OnInit {
services = [];
  constructor(private service: ServiceService) { }


  ngOnInit() {
    this.services = this.service.getServices();
    this.service.getServicesStream().subscribe(e=>{
        this.services.concat(e);
    })

  }


}
