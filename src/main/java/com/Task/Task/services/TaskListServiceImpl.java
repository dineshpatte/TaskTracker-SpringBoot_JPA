package com.Task.Task.services;

import com.Task.Task.Domain.Entities.Task;
import com.Task.Task.Domain.Entities.TaskList;
import com.Task.Task.repositories.TaskListRepository;
import com.Task.Task.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }
    @Override
    public List<TaskList> listTaskLists() {
       return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {

        if(null!=taskList.getTasks()){
            throw new IllegalArgumentException("Task list already exists");

        }
        if(null == taskList.getTitle()|| taskList.getTitle().isEmpty()){
            throw new IllegalArgumentException("Task list title is empty");
        }

        LocalDateTime now = LocalDateTime.now();
        taskListRepository.save(new TaskList(
              null,
              taskList.getTitle(),
              taskList.getDescription(),
              null,
              now,
              now
        ));
        return null;
    }

    @Override
    public TaskList updateTaskList(TaskList taskList) {
        return null;
    }
}
