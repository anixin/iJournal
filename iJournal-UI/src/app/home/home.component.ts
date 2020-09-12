import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.styl'],
  providers: [DatePipe]
})
export class HomeComponent implements OnInit {

  constructor(private service : RestService, private router: Router,private datePipe: DatePipe) { }
  public schedule: any = [];
  public taskCategory: any = [];
  private myDate = new Date();
  ngOnInit() {
    this.getAllTaskCategory();
  }

  getAllTaskCategory(){
    this.service.getAllTaskService().subscribe((data) => {
      this.taskCategory = data;
    });

  }

  addTask() {
    console.log(this.schedule);
    this.schedule.push({
      taskName: "",
      toDo: "",
      timeCommitted: "",
      date: this.datePipe.transform(this.myDate, 'yyyy-MM-dd'),
      workDone: "",
      toBeDoneNext: "",
      actualTime: 5,
    });
  }

  saveSchedule(){
    console.log("saewwdvf clicked");
    this.service.saveTodaysScheduleService(this.schedule).subscribe((data => {
      console.log(data);
    }));
  }

}
