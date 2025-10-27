package com.Task.Task.services;

import com.Task.Task.Domain.Entities.TaskList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface TaskListService {

    List<TaskList> listTaskLists();

    TaskList createTaskList(TaskList taskList);
    TaskList updateTaskList(UUID taskListId,TaskList taskList);

    void deleteTaskList(UUID taskListId);

    Optional<TaskList> getTaskListById(UUID taskListId);



}
