package com.zchadli.task_backend.services.impl;

import com.zchadli.task_backend.dao.TaskDao;
import com.zchadli.task_backend.dto.request.TaskRequest;
import com.zchadli.task_backend.mapper.TaskMapper;
import com.zchadli.task_backend.model.Task;
import com.zchadli.task_backend.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;
    private final TaskMapper taskMapper;
    @Override
    public List<Task> getAll() {
        return taskDao.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskDao.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public Void deleteById(Long id) {
        Task task = taskDao.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        taskDao.delete(task);
        return null;
    }

    @Override
    public Task save(TaskRequest taskRequest) {
        Task task = taskMapper.toTask(taskRequest);
        return taskDao.save(task);
    }
}
