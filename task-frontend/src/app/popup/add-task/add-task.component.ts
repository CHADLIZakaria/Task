import { Component, signal } from '@angular/core';
import { MatButton } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { TaskRequest } from '../../models/task.model';
import {form, FormField} from '@angular/forms/signals';

@Component({
  selector: 'app-add-task',
  imports: [MatFormFieldModule, MatInputModule, MatIconModule, MatButton ],
  templateUrl: './add-task.component.html',
  styleUrl: './add-task.component.scss'
})
export class AddTaskComponent {
  taskModel = signal<TaskRequest>({
    description: ''
  })
  taskForm = form(this.taskModel)

  save() {

  }
}
