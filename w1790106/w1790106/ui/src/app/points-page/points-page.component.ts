import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-points-page',
  templateUrl: './points-page.component.html',
  styleUrls: ['./points-page.component.css']
})
export class PointsPageComponent implements OnInit {

  todos: any;
  url: string | undefined;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:4200/points"
    this.http.get(this.url)
      .subscribe(response => {
        console.log(response);
        this.todos = response;
      });
  }

  ngOnInit(): void {
  }

}
