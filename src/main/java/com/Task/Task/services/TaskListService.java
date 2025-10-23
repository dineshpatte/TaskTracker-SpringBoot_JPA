package com.Task.Task.services;

import com.Task.Task.Domain.Entities.TaskList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskListService {

    List<TaskList> listTaskLists();

    TaskList createTaskList(TaskList taskList);
    TaskList updateTaskList(TaskList taskList);
}
