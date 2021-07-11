import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { HttpClientModule } from "@angular/common/http";
import { PointsPageComponent } from './points-page/points-page.component';
import { GoalsPageComponent } from './goals-page/goals-page.component';
import { WinsPageComponent } from './wins-page/wins-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    PointsPageComponent,
    GoalsPageComponent,
    WinsPageComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
