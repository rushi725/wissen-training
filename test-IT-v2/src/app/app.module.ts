import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';

import { RouterModule, Routes } from '@angular/router';
import { TodoComponent } from './todo/todo.component';
import { TodoListComponent } from './todo-list/todo-list.component';
import { TodoFormComponent } from './todo-form/todo-form.component';

var routes: Routes = [
  { path: '', component: NavbarComponent},
  { path:'todos',component: TodoListComponent
    // children:[
    //   {
    //     path:'addTodo',component:TodoFormComponent
    //   }
    // ]
  },
   { path:'todos',outlet:"addTodo",component:TodoFormComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    TodoComponent,
    TodoListComponent,
    TodoFormComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
