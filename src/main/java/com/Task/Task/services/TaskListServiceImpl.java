package com.Task.Task.services;

import com.Task.Task.Domain.Entities.TaskList;
import com.Task.Task.repositories.TaskListRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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
      TaskList saved;
        saved = taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
          ));
        return saved;
    }

    @Override

    public TaskList updateTaskList(UUID taskListId, TaskList taskList) {

        if (taskListId == null) {
            throw new IllegalArgumentException("Task list id not provided");
        }

        TaskList existingTaskList = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new IllegalArgumentException("Task list id doesn't exist"));

        existingTaskList.setTitle(taskList.getTitle());
        existingTaskList.setDescription(taskList.getDescription());
        existingTaskList.setUpdated(LocalDateTime.now());

        return taskListRepository.save(existingTaskList);
    }


    @Override
    public void deleteTaskList(UUID taskListId) {
        if(null==taskListId){
            throw new IllegalArgumentException("task list id is null");
        }

        taskListRepository.deleteById(taskListId);

    }

    @Override
    public Optional<TaskList> getTaskListById(UUID taskListId) {
      return Optional.ofNullable(taskListRepository.findById(taskListId).orElseThrow(() ->
              new IllegalArgumentException("Task list not found with id: " + taskListId)));
    }
}
