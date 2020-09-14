import { RestService } from './../rest.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.styl']
})
export class TaskComponent implements OnInit {

  public taskCategoryList: any = [];

  constructor(private service : RestService) { }

  ngOnInit() {
    this.service.getAllTaskService().subscribe((data) => {
      this.taskCategoryList = data;
    });
  }

}
