import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.styl']
})
export class HomeComponent implements OnInit {

  constructor() { }
  public schedule: any = [];

  ngOnInit() {
    /* this.schedule.push({
      toDo: "Do Leetcode",
      timeCommitted: '15 mins'
    }); */
  }

  addTask() {
    this.schedule.push({
      toDo: "",
      timeCommitted: ""
    });
  }

}
