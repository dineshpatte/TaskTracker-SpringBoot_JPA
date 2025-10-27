package com.Task.Task.services;

import com.Task.Task.Domain.Entities.Task;
import com.Task.Task.repositories.TaskRepository;

import java.util.List;
import java.util.UUID;

public class TaskServiceImpl implements TaskService {


    private TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }
}
