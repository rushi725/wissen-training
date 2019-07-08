import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { FoodItemComponent } from './food-item/food-item.component';
import { ReviewComponent } from './review/review.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CartBadgeComponent } from './cart-badge/cart-badge.component';
import { CartViewComponent } from './cart-view/cart-view.component';
import { ItemListComponent } from './item-list/item-list.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { ReviewFormComponent } from './review-form/review-form.component';


var routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'items', 
   component: ItemListComponent,
    children :[
    {
        path: 'addReview',
        component:ReviewFormComponent
    }
     ] },
  { path: 'cart', component: CartViewComponent },
  { path: '**', component: NotFoundComponent },
]

@NgModule({
  declarations: [
    AppComponent,
    FoodItemComponent,
    ReviewComponent,
    NavbarComponent,
    CartBadgeComponent,
    CartViewComponent,
    ItemListComponent,
    HomeComponent,
    NotFoundComponent,
    ReviewFormComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
