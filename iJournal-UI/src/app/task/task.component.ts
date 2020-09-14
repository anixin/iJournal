import { RestService } from './../rest.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.styl']
})
export class TaskComponent implements OnInit {

  public taskCategoryList: any = [];

  constructor(private service : RestService, private router: Router) { }

  ngOnInit() {
    this.service.getAllTaskService().subscribe((data) => {
      this.taskCategoryList = data;
    });
  }

  getTaskHistory(taskName){
    this.router.navigate(['/task', taskName]);
  }

}
