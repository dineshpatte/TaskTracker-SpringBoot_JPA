package com.Task.Task.controllers;


import com.Task.Task.Domain.DTO.TaskListDto;
import com.Task.Task.Domain.Entities.TaskList;
import com.Task.Task.Mappers.TaskListMapper;
import com.Task.Task.services.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private TaskListService taskListservice;
    private  TaskListMapper taskListMapper;
    public TaskListController(TaskListService taskListservice, TaskListMapper taskListMapper) {
        this.taskListservice = taskListservice;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> getTaskList(){

       return  taskListservice.listTaskLists().stream().map(taskListMapper::toDto).toList();
    }

    @PatchMapping
    public TaskListDto createTAskList(@RequestBody TaskListDto taskListDto){
      TaskList createdTaskList =  taskListservice.createTaskList(
                taskListMapper.fromDto(taskListDto)
        );
        return  taskListMapper.toDto(createdTaskList);
    }
}
