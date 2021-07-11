import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WinsPageComponent } from "./wins-page/wins-page.component";
import { GoalsPageComponent } from "./goals-page/goals-page.component";
import { PointsPageComponent } from "./points-page/points-page.component";
import { HomePageComponent } from "./home-page/home-page.component";

const routes: Routes = [
  {path:"wins", component: WinsPageComponent},
  {path:"goals", component: GoalsPageComponent},
  {path:"points", component: PointsPageComponent},
  {path:"home", component: HomePageComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
