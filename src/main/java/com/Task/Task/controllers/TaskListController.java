package com.Task.Task.controllers;


import com.Task.Task.Domain.DTO.TaskListDto;
import com.Task.Task.Domain.Entities.TaskList;
import com.Task.Task.Mappers.TaskListMapper;
import com.Task.Task.services.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @PutMapping
    public TaskListDto createTAskList(@RequestBody TaskListDto taskListDto){
      TaskList createdTaskList =  taskListservice.createTaskList(
                taskListMapper.fromDto(taskListDto)
        );
        return  taskListMapper.toDto(createdTaskList);
    }

//    @PutMapping
//    public TaskListDto updateTAskList(@RequestBody TaskListDto taskListDto){
//        TaskList taskListDto1 = taskListMapper.fromDto(taskListDto);
//        TaskList  taskList =  taskListservice.updateTaskList(taskListDto1);
//
//        return taskListMapper.toDto(taskList);
//    }
//
//    @DeleteMapping
//    public void deleteTAskList(TaskListDto taskListDto){
//      TaskList teaskList = taskListMapper.fromDto(taskListDto);
//      taskListservice.deleteTaskList(teaskList);
//
//    }

    @GetMapping(path="/{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") UUID taskListId){
        return  taskListservice.getTaskListById(taskListId).map(taskListMapper::toDto);
    }

    @PutMapping(path="/{task_list_id}")
    public TaskListDto updateTaskList(@PathVariable("task_list_id") UUID taskListId,@RequestBody TaskListDto taskListDto){

        TaskList updatedtaskList =  taskListservice.updateTaskList(
                taskListId,
                taskListMapper.fromDto(taskListDto)
        );
        return  taskListMapper.toDto(updatedtaskList);

    }

    @DeleteMapping("{/task_list_id}")
    public void deleteTaskList(@PathVariable("task_list_id") UUID taskListId){
        taskListservice.deleteTaskList(taskListId);
    }



}
