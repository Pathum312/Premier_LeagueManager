import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-points-page',
  templateUrl: './matches-page.component.html',
  styleUrls: ['./matches-page.component.css']
})
export class MatchesPageComponent implements OnInit {

  todos: any;
  url: string | undefined;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:4200/matches"
    this.http.get(this.url)
      .subscribe(response => {
        console.log(response);
        this.todos = response;
      });
  }

  ngOnInit(): void {
  }

}
