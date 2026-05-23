package com.zchadli.task_backend.services;

import com.zchadli.task_backend.dto.request.TaskRequest;
import com.zchadli.task_backend.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();
    Task findById(Long id);
    Void deleteById(Long id);
    Task save(TaskRequest task);
}
