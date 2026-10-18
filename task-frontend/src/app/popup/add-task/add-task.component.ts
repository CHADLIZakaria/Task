import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButton } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { TaskService } from '../../services/task.service';

@Component({
  selector: 'app-add-task',
  imports: [MatFormFieldModule, MatInputModule, MatIconModule, MatButton, ReactiveFormsModule ],
  templateUrl: './add-task.component.html',
  styleUrl: './add-task.component.scss'
})
export class AddTaskComponent {
  taskForm = new FormGroup({
    description: new FormControl('', {
      nonNullable: true,
      validators: [Validators.required]
    })
  })
  taskService = inject(TaskService)

  save() {
    console.log(this.taskForm.getRawValue())
    this.taskService.saveTask(this.taskForm.getRawValue()).subscribe({
      next: () => console.log("added")
    })
  }
}
