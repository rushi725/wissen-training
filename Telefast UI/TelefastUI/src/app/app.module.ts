import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ScrollDispatchModule} from '@angular/cdk/scrolling';
import {ScrollingModule} from '@angular/cdk/scrolling';
import { RouterModule, Routes } from '@angular/router';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ServiceListComponent } from './service-list/service-list.component';
import { TeamComponent } from './team/team.component';
import { TeamListComponent } from './team-list/team-list.component';
import { ServiceFormComponent } from './service-form/service-form.component';
import { TeamFormComponent } from './team-form/team-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { OrderedTaskListComponent } from './ordered-task-list/ordered-task-list.component';
import { TaskListComponent } from './task-list/task-list.component';
import { OrderedTaskDetailComponent } from './ordered-task-detail/ordered-task-detail.component';
import { StatusChangeComponent } from './status-change/status-change.component';
import { TaskStatusComponent } from './task-status/task-status.component';
import { OrderedServiceListComponent } from './ordered-service-list/ordered-service-list.component';

const routes: Routes = [
  { path: '', component: NavbarComponent},
  { path: 'dashboard', component: ServiceListComponent},
  // { path:'dashboard',outlet:"addService",component:ServiceFormComponent},
  // { path:'dashboard',outlet:"addTeam",component:TeamFormComponent},
  { path: 'dashboard', component: TeamListComponent},
  { path: 'orderedTasks', component: OrderedTaskListComponent},
  {path : 'orderedTask', component: TaskStatusComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    ServiceListComponent,
    TeamComponent,
    TeamListComponent,
    ServiceFormComponent,
    TeamFormComponent,
    OrderedTaskListComponent,
    TaskListComponent,
    OrderedTaskDetailComponent,
    StatusChangeComponent,
    TaskStatusComponent,
    OrderedServiceListComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ScrollDispatchModule,
    ScrollingModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
