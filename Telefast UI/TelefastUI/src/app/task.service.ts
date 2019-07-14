import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  tasks = [
    {
      id: 1,
      taskName : 'task1',
      desc : 'desc 1',
      duration: '12',
      approval : true,
    },
    {
      id: 1,
      taskName : 'task1',
      desc : 'desc 1',
      duration: '12',
      approval : true,
    },
    {
      id: 1,
      taskName : 'task1',
      desc : 'desc 1',
      duration: '12',
      approval : true,
    },
    {
      id: 1,
      taskName : 'task1',
      desc : 'desc 1',
      duration: '12',
      approval : true,
    },
    {
      id: 1,
      taskName : 'task1',
      desc : 'desc 1',
      duration: '12',
      approval : true,
    }
  ];
  constructor() { }
  orderedTasksStream: Subject<any> = new Subject();

  getStream() {
    return this.orderedTasksStream;
  }

  getOrderedTasks() {
    return this.tasks;
  }

  publishStream() {
    this.orderedTasksStream.next({orderedTasks: this.tasks});
  }

  addTask(task) {
    this.tasks.push(task);
    this.publishStream();
  }
}
