import { Component, OnInit } from '@angular/core';
import { OrderedTaskService } from '../ordered-task.service';

@Component({
  selector: 'app-ordered-task-list',
  templateUrl: './ordered-task-list.component.html',
  styleUrls: ['./ordered-task-list.component.scss']
})
export class OrderedTaskListComponent implements OnInit {

  constructor(private orderedTaskservice : OrderedTaskService ) { }

  orderedTasks = []

  ngOnInit() {

    this.orderedTasks = this.orderedTaskservice.getOrderedTasks();
    this.orderedTaskservice.getStream().subscribe(e=>
      this.orderedTasks.concat(e)); 
  }

}
