import { JsonPipe, TitleCasePipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { AddTaskComponent } from './popup/add-task/add-task.component';
import {  MatDialog } from '@angular/material/dialog';
import { TaskService } from './services/task.service';
import { LoadingComponent } from './components/loading/loading.component';
import { AlertComponent } from './components/alert/alert.component';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-root',
  imports: [MatListModule, TitleCasePipe, MatIconModule, MatFormFieldModule, MatInputModule, MatIconModule, LoadingComponent, AlertComponent, MatButtonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  fragments = ['inbox', 'outbox', 'drafts'];
  activeLink: string | null = null;
  dialog = inject(MatDialog);
  taskService = inject(TaskService)
  openDialog() {
    this.dialog.open(AddTaskComponent);
  }
}
