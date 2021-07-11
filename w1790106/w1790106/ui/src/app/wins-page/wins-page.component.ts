import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-points-page',
  templateUrl: './wins-page.component.html',
  styleUrls: ['./wins-page.component.css']
})
export class WinsPageComponent implements OnInit {

  todos: any;
  url: string | undefined;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:4200/wins"
    this.http.get(this.url)
      .subscribe(response => {
        console.log(response);
        this.todos = response;
      });
  }

  ngOnInit(): void {
  }

}
