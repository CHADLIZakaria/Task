package com.zchadli.task_backend.mapper;

import com.zchadli.task_backend.dto.request.TaskRequest;
import com.zchadli.task_backend.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toTask(TaskRequest taskRequest);
    TaskRequest toTaskRequest(Task task);
}
