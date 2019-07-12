import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ScrollDispatchModule} from '@angular/cdk/scrolling';
import {ScrollingModule} from '@angular/cdk/scrolling';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ServiceListComponent } from './service-list/service-list.component';
import { TeamComponent } from './team/team.component';
import { TeamListComponent } from './team-list/team-list.component';
import { ServiceFormComponent } from './service-form/service-form.component';
import { TeamFormComponent } from './team-form/team-form.component';
import { ReactiveFormsModule } from '@angular/forms';

var routes: Routes = [
  { path: '', component: NavbarComponent},
  { path:'dashboard',component: ServiceListComponent},
  { path:'dashboard',outlet:"addService",component:ServiceFormComponent},
  { path:'dashboard',outlet:"addTeam",component:TeamFormComponent},
  { path:'dashboard',outlet:"teams",component:TeamListComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    ServiceListComponent,
    TeamComponent,
    TeamListComponent,
    ServiceFormComponent,
    TeamFormComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ScrollDispatchModule,
    ScrollingModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
