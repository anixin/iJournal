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

  constructor(private service: RestService, private router: Router, private datePipe: DatePipe) { }
  public schedule: any = [];
  public taskCategory: any = [];
  private myDate = new Date();
  public timeLeft;
  public interval = [];
  public isSaved = false;
  public taskCompleted = false;
  public message;
  ngOnInit() {
    this.getAllTaskCategory();
    this.getTodaySchedule();
  }

  getAllTaskCategory() {
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
      isCompleted: false,
      timeLeft: ""
    });
  }

  saveSchedule() {
    console.log("saewwdvf clicked");
    this.service.saveTodaysScheduleService(this.schedule).subscribe((data) => {
      this.message = data;
      this.isSaved = true;
    });
  }
  getTodaySchedule(){
    this.service.getTodayScheduleService(this.datePipe.transform(this.myDate, 'yyyy-MM-dd')).subscribe((data) =>{
      this.schedule = data;
    })    
  }

  updateSchedule() {
    let completedTaskList = [];
    this.schedule.forEach(element => {
      if (element.isCompleted)
        completedTaskList.push(element);
    });

    this.service.updateTasksService(completedTaskList).subscribe((data) => {
      console.log(data);
    });
  }

  startTimer(i) {
    let task = this.schedule[i];

    this.schedule[i].timeLeft = this.schedule[i].timeLeft ? this.schedule[i].timeLeft: task.timeCommitted * 60;
    this.interval[i] = setInterval(() => {
      if (this.schedule[i].timeLeft > 0)
        this.schedule[i].timeLeft--;
      else {
        alert("Task completed: " + task.taskName)
        clearInterval(this.interval[i]);
        task.isCompleted = true;
        this.schedule[i].timeLeft = null;
        this.taskUpdated();
      }
    }, 1000);
  }

  pauseTimer(i) {
    console.log(this.schedule[i].timeLeft)
    clearInterval(this.interval[i]);
  }

  taskUpdated() {
    this.schedule.forEach(element => {
      if (element.isCompleted) {
        this.taskCompleted = true;
      }
    });
  }

  onTaskChange(i){
    console.log(this.schedule[i].taskName);
    let w2D;
    this.service.getWorkToDoService(this.schedule[i].taskName).subscribe((data) =>{
      w2D = data;
      this.schedule[i].toDo = w2D;
    });
  }

}
