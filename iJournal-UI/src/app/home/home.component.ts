import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.styl']
})
export class HomeComponent implements OnInit {

  constructor(private service : RestService, private router: Router) { }
  public schedule: any = [];
  public taskCategory: any = [];

  ngOnInit() {
    this.getAllTaskCategory();
  }

  getAllTaskCategory(){
    this.service.getAllTaskService().subscribe((data) => {
      this.taskCategory = data;
    });

  }

  addTask() {
    this.schedule.push({
      toDo: "",
      timeCommitted: ""
    });
  }

}
