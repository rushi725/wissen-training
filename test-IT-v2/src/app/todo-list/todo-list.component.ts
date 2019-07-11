import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

  constructor() { }

  todos =[
    {
      id:1,
      title:"Learn javascript",
      body:"It's easy",
      dateOfcreation: "01/12/2018",
      completed:true
    },
    {
      id:2,
      title:"Learn java",
      body:"It's very easy",
      dateOfcreation: "02/12/2018",
      completed:false
    },
    {
      id:3,
      title:"Learn Angular",
      body:"It's not  easy",
      dateOfcreation: "03/10/2018",
      completed:true
    }
  ]

  ngOnInit() {
  }

}
