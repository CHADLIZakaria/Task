import { HttpClient, httpResource } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { ResponseApi, Task } from '../models/task.model';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private http = inject(HttpClient)

  constructor() { }

  tasks = httpResource<ResponseApi<Task[]>>(() => 'http://localhost:8080/tasks')

  saveTask() {
    
  }
}
