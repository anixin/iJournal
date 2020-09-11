import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  private getAllTaskCategoryQ = 'http://localhost:8080/getAllTasks';

  constructor(private http: HttpClient) { }

  public getAllTaskService(){
    return this.http.get(this.getAllTaskCategoryQ)/* .pipe(
      map(this.extractData),
      // ,catchError
    )*/; 
  }
}
