import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { DatePipe } from '@angular/common';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.styl'],
  providers: [DatePipe]
})
export class DashboardComponent implements OnInit {

  constructor(private service: RestService, private datePipe: DatePipe) { }

  private date = new Date();
  private today;
  private startDate;
  private endDate;
  public taskHistoryList;

  ngOnInit() {
    this.today = this.datePipe.transform(this.date, 'yyyy-MM-dd');
    this.startDate = this.datePipe.transform(new Date(this.date.getFullYear(), this.date.getMonth(), this.date.getDate() - 7), 'yyyy-MM-dd');
    console.log(this.startDate);
    console.log(this.today);
    this.service.getDayBatchHistoryService(this.startDate, this.today).subscribe((data) =>{
      console.log(data);
      this.taskHistoryList = data;
    });
  }

  getSchedule(){
    if(this.startDate > this.endDate){
      alert("Start date is greater");
    }
    this.service.getDayBatchHistoryService(this.startDate, this.endDate).subscribe((data)=>{
      console.log(data);
      this.taskHistoryList = data;
    })
    
  }

}
