package com.Task.Task.controllers;


import com.Task.Task.Domain.DTO.TaskDto;
import com.Task.Task.Domain.Entities.Task;
import com.Task.Task.Mappers.TaskMapper;
import com.Task.Task.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    public List<TaskDto> findByTaskListIdAndId( UUID taskListId, UUID taskId) {

        return taskService.listTasks(taskListId).stream().map(taskMapper::toDto)
                .toList();

    }

    @PostMapping
    public TaskDto createTask(@PathVariable("task_list_id") UUID taskListId, @RequestBody TaskDto taskDto) {
       Task createTask = taskService.CreateTask(taskListId,taskMapper.fromDto(taskDto));

       return taskMapper.toDto(createTask);
    }

    @GetMapping(path = "/{task_id}")
    public Optional<TaskDto> getTask(@PathVariable("task_list_id") UUID   taskListId,@PathVariable("task_id") UUID taskId) {
        return taskService.getTask(taskListId,taskId).map(taskMapper::toDto);

    }

    @PutMapping(path = "/{task_id}")
    public TaskDto updateTask(@PathVariable("task_list_id") UUID taskListId, @PathVariable("task_id") UUID taskId,@RequestBody TaskDto taskDto) {
        Task updatedTask = taskService.updateTask(taskListId,taskId,taskMapper.fromDto(taskDto));
        return taskMapper.toDto(updatedTask);
    }

    @DeleteMapping(path = "/{task_id}")
    public void deleteTask(@PathVariable("task_list_id")UUID  taskListId, @PathVariable("task_id") UUID taskId) {
        taskService.deleteTask(taskListId,taskId);
    }




}
