package com.Task.Task.controllers;


import com.Task.Task.Domain.DTO.TaskDto;
import com.Task.Task.Mappers.TaskMapper;
import com.Task.Task.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-lists/{task_list_id}/tasks")
public class TaskController {

    private final TaskMapper taskMapper;
    private final TaskService taskService;
    public TaskController(TaskMapper taskMapper, TaskService taskService) {
        this.taskMapper = taskMapper;
        this.taskService = taskService;

    }


    @GetMapping
    public List<TaskDto> findByTaskListIdAndId(UUID taskListId, UUID taskId) {

        return taskService.listTasks(taskListId).stream().map(taskMapper::toDto)
                .toList();

    }




}
