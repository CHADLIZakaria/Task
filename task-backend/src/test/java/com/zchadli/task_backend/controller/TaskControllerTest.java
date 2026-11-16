
package com.zchadli.task_backend.controller;

import com.zchadli.task_backend.dto.request.TaskRequest;
import com.zchadli.task_backend.model.Task;
import com.zchadli.task_backend.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskControllerTest {

    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    private Task task;

    @BeforeEach
    void setUp() {
        task = mock(Task.class);
    }

    // Test 1: Get all tasks
    @Test
    void shouldGetAllTasks() {
        List<Task> tasks = List.of(task);

        when(taskService.getAll()).thenReturn(tasks);

        var response = taskController.getAll();

        assertNotNull(response);
        verify(taskService, times(1)).getAll();
    }

    // Test 2: Find task by ID
    @Test
    void shouldFindTaskById() {
        Long id = 1L;

        when(taskService.findById(id)).thenReturn(task);

        var response = taskController.findById(id);

        assertNotNull(response);
        verify(taskService, times(1)).findById(id);
    }

    // Test 3: Delete task by ID
    @Test
    void shouldDeleteTaskById() {
        Long id = 1L;

        var response = taskController.deleteById(id);

        assertNotNull(response);
        verify(taskService, times(1)).deleteById(id);
    }

    // Test 4: Save task
    @Test
    void shouldSaveTask() {
        TaskRequest request = mock(TaskRequest.class);

        when(taskService.save(request)).thenReturn(task);

        var response = taskController.save(request);

        assertNotNull(response);
        verify(taskService, times(1)).save(request);
    }
}