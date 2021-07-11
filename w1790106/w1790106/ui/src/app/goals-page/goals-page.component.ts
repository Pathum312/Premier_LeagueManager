import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-points-page',
  templateUrl: './goals-page.component.html',
  styleUrls: ['./goals-page.component.css']
})
export class GoalsPageComponent implements OnInit {

  todos: any;
  url: string | undefined;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:4200/goals"
    this.http.get(this.url)
      .subscribe(response => {
        console.log(response);
        this.todos = response;
      });
  }

  ngOnInit(): void {
  }

}
