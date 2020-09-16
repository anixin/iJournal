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
  public timeLeft;
  public interval;
  public isSaved = false;
  public taskCompleted = false;
  public message;
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
      isCompleted: false,
      timeLeft: ""
    });
  }

  saveSchedule(){
    console.log("saewwdvf clicked");
    this.service.saveTodaysScheduleService(this.schedule).subscribe((data) => {
      this.message = data;
      this.isSaved = true;
    });
  }

  updateSchedule(){
    let completedTaskList = [];
    this.schedule.forEach(element => {
      if(element.isCompleted)
        completedTaskList.push(element);
    });

    this.service.updateTasksService(completedTaskList).subscribe((data) => {
      console.log(data);
    });
  }

  startTimer(i){
    let task = this.schedule[i];
    this.timeLeft = this.timeLeft ? this.timeLeft : task.timeCommitted * 60;
    this.interval = setInterval(() => {
      if(this.timeLeft > 0)
        this.timeLeft --;
      else{
        alert("Task completed: "+ task.taskName)
        clearInterval(this.interval);
        task.isCompleted = true;
        this.timeLeft = null;
        this.taskUpdated();
      }
    },1000);
  }

  pauseTimer(){
    console.log(this.timeLeft);
    clearInterval(this.interval);
  }

  taskUpdated(){
    this.schedule.forEach(element => {
      if(element.isCompleted){
        this.taskCompleted = true;
      }
    });
  }

}
