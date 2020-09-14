import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  private getAllTaskCategoryQ = 'http://localhost:8080/getAllTasks';
  private saveTodaysScheduleQ = 'http://localhost:8080/addTodaysSchedule';
  private getTaskHistoryQ = 'http://localhost:8080/getTaskHistory/';

  constructor(private http: HttpClient) { }
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  public getAllTaskService() {
    return this.http.get(this.getAllTaskCategoryQ)/* .pipe(
      map(this.extractData),
      // ,catchError
    )*/;
  }

  public saveTodaysScheduleService(scheduleList) {
    let data = this.http.post(this.saveTodaysScheduleQ, JSON.stringify(
      scheduleList
    ), this.httpOptions);
    return data;
  }

  public getTaskHistoryService(task){
    return this.http.get(this.getTaskHistoryQ + task);
  }
}
