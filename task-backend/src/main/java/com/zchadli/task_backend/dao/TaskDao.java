package com.zchadli.task_backend.dao;

import com.zchadli.task_backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task, Long> {
}
