import { Component, OnInit } from '@angular/core';
import { RestService } from './../rest.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-task-history',
  templateUrl: './task-history.component.html',
  styleUrls: ['./task-history.component.styl']
})
export class TaskHistoryComponent implements OnInit {

  constructor(private service : RestService, private actRoute: ActivatedRoute) { }
  public taskName;
  public taskHistoryList : any = [];

  ngOnInit() {
    this.taskName = this.actRoute.snapshot.params['taskName']
    this.service.getTaskHistoryService(this.taskName).subscribe((data) => {
      this.taskHistoryList = data;
      console.log(this.taskHistoryList);
    });
  }

}
