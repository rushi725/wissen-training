import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { FoodItemComponent } from './food-item/food-item.component';
import { ReviewComponent } from './review/review.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CartBadgeComponent } from './cart-badge/cart-badge.component';
import { CartViewComponent } from './cart-view/cart-view.component';
import { ItemListComponent } from './item-list/item-list.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';


var routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'items', component: ItemListComponent },
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
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
