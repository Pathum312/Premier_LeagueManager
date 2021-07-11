import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PointsPageComponent } from "./points-page/points-page.component";
import { HomePageComponent } from "./home-page/home-page.component";

const routes: Routes = [
  {path:"points", component: PointsPageComponent},
  {path:"home", component: HomePageComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
