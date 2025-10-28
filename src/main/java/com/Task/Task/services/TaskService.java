package com.Task.Task.services;

import com.Task.Task.Domain.Entities.Task;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public interface TaskService {
List<Task> listTasks(UUID taskListId);
Task CreateTask(UUID taskListId, Task  task);
Optional<Task> getTask(UUID taskListId, UUID taskId);
Task updateTask(UUID taskListId, UUID taskId, Task  task);
@Transactional
void deleteTask(UUID taskListId, UUID taskId);
}


