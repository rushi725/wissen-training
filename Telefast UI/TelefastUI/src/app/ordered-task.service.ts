import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderedTaskService {
  orderedTasks = [
    {
      id:1,
      taskName : 'task1',
      teamMember : 'Member 1',
      status : 'In Progress',
      approved : false,
      date : "06/06/2019"
    },
    {
      id:1,
      taskName : 'task1',
      teamMember : 'Member 1',
      status : 'In Progress',
      approved : false,
      date : "06/06/2019"
    },
    {
      id:1,
      taskName : 'task1',
      teamMember : 'Member 1',
      status : 'In Progress',
      approved : false,
      date : "06/06/2019"
    },
    {
      id:1,
      taskName : 'task1',
      teamMember : 'Member 1',
      status : 'In Progress',
      approved : false,
      date : "06/06/2019"
    },
    {
      id:1,
      taskName : 'task1',
      teamMember : 'Member 1',
      status : 'In Progress',
      approved : false,
      date : "06/06/2019"
    }
  ]
  constructor() { }
  orderedTasksStream : Subject<any> = new Subject();

  getStream(){
    return this.orderedTasksStream;
  }

  getOrderedTasks(){
    return this.orderedTasks;
  }

  publishStream(){
    this.orderedTasksStream.next({orderedTasks:this.orderedTasks})
  }
}
