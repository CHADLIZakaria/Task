import { HttpClient, httpResource } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { ResponseApi, Task, TaskRequest } from '../models/task.model';
import { environment } from '../../environments/environment.development';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private http = inject(HttpClient)

  constructor() { }

  tasks = httpResource<ResponseApi<Task[]>>(() => `${environment.apiUrl}/tasks`)

  saveTask(task: TaskRequest) {
    return this.http.post(`${environment.apiUrl}/tasks`, task)
    .pipe(tap(() => this.tasks.reload()))
  }
}
