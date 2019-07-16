import { Injectable } from '@angular/core';
import { Subject, BehaviorSubject } from 'rxjs';
import { Task } from './task.model';
import { Employee } from './employee.model';
import { Team } from './team.model';

@Injectable({
  providedIn: 'root'
})


export class TaskNode {
  children: BehaviorSubject<TaskNode[]>;
  constructor(public task: any, children?: TaskNode[], public parent?: TaskNode) {
    this.children = new BehaviorSubject(children === undefined ? [] : children);
  }
}

export class WorkflowService {

  constructor() { }

  workFlowStream : Subject<any> = new Subject();

  workFlow = [
    {
      id : 1,
      task : new Task(1,'Task 1','Desc 1',10,true),
      team : new Team(100,'Team 1','Desc 1'),
      seqNo : 1,
      prev : null
    },
    {
      id : 2,
      task : new Task(1,'Task 2','Desc 2',10,true),
      team : new Team(102,'Team 2','Desc 2'),
      seqNo : 2,
      prev : 1
    }
    ,
    {
      id : 3,
      task : new Task(3,'Task 3','Desc 2',10,true),
      team : new Team(103,'Team 3','Desc 2'),
      seqNo : 3,
      prev : 1
    },
    {
      id : 4,
      task : new Task(4,'Task 4','Desc 3',10,true),
      team : new Team(104,'Team 4','Desc 3'),
      seqNo : 4,
      prev : 2
    },
    {
      id : 5,
      task : new Task(4,'Task 4','Desc 4',10,true),
      team : new Team(103,'Team 4','Desc 4'),
      seqNo : 5,
      prev : 3
    },
  ];
  tasks = [
    {
        id:1,
        task: new Task(1,'Task 1','Desc 1',10,true),
        employee : new Employee(10,new Team(100,'Team 1','Desc 1'),'Rushabh','Shah','Team_Member','Address 1','9096678120',false),
        status : 'In Progress',
        date : '04/05/2018',
        approved : null,
        denialReason : null
    },
    {
      id:2,
      task: new Task(1,'Task 2','Desc 1',10,true),
      employee : new Employee(10,new Team(100,'Team 1','Desc 1'),'Rushabh','Shah','Team_Member','Address 1','9096678120',false),
      status : 'In Progress',
      date : '04/05/2018',
      approved : null,
      denialReason : null
  },
  {
    id:3,
    task: new Task(1,'Task 3','Desc 1',10,true),
    employee : new Employee(10,new Team(100,'Team 1','Desc 1'),'Rushabh','Shah','Team_Member','Address 1','9096678120',false),
    status : 'In Progress',
    date : '04/05/2018',
    approved : null,
    denialReason : null
  },
  {
    id:4,
    task: new Task(1,'Task 4','Desc 1',10,true),
    employee : new Employee(10,new Team(100,'Team 1','Desc 1'),'Rushabh','Shah','Team_Member','Address 1','9096678120',false),
    status : 'In Progress',
    date : '04/05/2018',
    approved : null,
    denialReason : null
  },
  {
    id:5,
    task: new Task(1,'Task 5','Desc 1',10,true),
    employee : new Employee(10,new Team(100,'Team 1','Desc 1'),'Rushabh','Shah','Team_Member','Address 1','9096678120',false),
    status : 'In Progress',
    date : '04/05/2018',
    approved : null,
    denialReason : null
  }
  ]

  taskWorkflow = []

  
  getWorkFlowStream() {
    return this.workFlowStream;
  }

  getWorkFlow(){
    return this.workFlow;
  }

  publishStream() {
    this.workFlowStream.next(e=>{taskFlow : this.workFlow});
  }

  createWorkflow() {
      let currentTask = this.tasks.find(t=>t.task.id === this.workFlow.find(e=>e.seqNo===1).task.id);
      let prev = 1;
      let nextTasks: Array<any> = this.workFlow.filter(e=>e.prev===prev);
      let taskNode  = new TaskNode(currentTask,nextTasks);
      this.taskWorkflow.push(taskNode);
      while(true){

      }
  }

}
