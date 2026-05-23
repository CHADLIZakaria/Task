package com.zchadli.task_backend.controller;

import com.zchadli.task_backend.dto.request.TaskRequest;
import com.zchadli.task_backend.dto.response.ResponseApi;
import com.zchadli.task_backend.model.Task;
import com.zchadli.task_backend.services.TaskService;
import com.zchadli.task_backend.util.ResponseApiUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@Tag(name = "Task API", description = "Operation related to tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    @Operation(
            summary = "Get all tasks",
            description = "Return all tasks",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Get all tasks")
            }
    )
    public ResponseApi<List<Task>> getAll() {
        return ResponseApiUtil.success(
                HttpStatus.OK.value(),
                "retrieve task success",
                taskService.getAll()
        );
    }

    @GetMapping(value = "{id}")
    @Operation(
            summary = "Get task By id",
            description = "Return task",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Get task"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    public ResponseApi<Task> findById(@PathVariable Long id) {
        return ResponseApiUtil.success(
                HttpStatus.OK.value(),
                "retrieve task success",
                taskService.findById(id)
        );
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Delete task by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Get task"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    public ResponseApi<Void> deleteById(@PathVariable Long id) {
        return ResponseApiUtil.success(
                HttpStatus.OK.value(),
                "Task deleted",
                taskService.deleteById(id)
        );
    }

    @PostMapping
    @Operation(
            summary = "Save task"
    )
    public ResponseApi<Task> save(@RequestBody TaskRequest taskRequest) {
        return ResponseApiUtil.success(
                HttpStatus.OK.value(),
                "save request success",
                taskService.save(taskRequest)
        );
    }
}
