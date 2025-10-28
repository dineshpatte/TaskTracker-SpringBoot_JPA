package com.Task.Task.services;

import com.Task.Task.Domain.Entities.Task;
import com.Task.Task.Domain.Entities.TaskList;
import com.Task.Task.Domain.Entities.TaskPriority;
import com.Task.Task.Domain.Entities.TaskStatus;
import com.Task.Task.repositories.TaskListRepository;
import com.Task.Task.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
@Service
public class TaskServiceImpl implements TaskService {


    private TaskRepository taskRepository;
    private TaskListRepository taskListRepository;
    public TaskServiceImpl(TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }
    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task CreateTask(UUID taskListId, Task task) {
        if(null!=task.getId()){
            throw new IllegalArgumentException("Task already exists");
        }

        if(null==task.getTitle()){
            throw new IllegalArgumentException("Task title is null");
        }

      TaskPriority taskPriority =   Optional.ofNullable(task.getTaskPriority()).orElse(TaskPriority.MEDIUM);

        TaskStatus taskStatus = TaskStatus.OPEN;

     TaskList taskList =    taskListRepository.findById(taskListId).orElseThrow(()-> new IllegalArgumentException("Task list id not found"));


        LocalDateTime now = LocalDateTime.now();
            Task newTask = new Task(
                    null,
                    task.getTitle(),
                    task.getDescription(),
                    task.getDueDate(),
                    taskStatus,
                    taskPriority,
                    taskList,
                    now,
                    now
            );

            return taskRepository.save(newTask);
    }

    @Override
    public Optional<Task> getTask(UUID taskListId, UUID taskId) {

        return taskRepository.findByTaskListIdAndId(taskListId,taskId);
    }

    @Override
    public Task updateTask(UUID taskListId, UUID taskId, Task task) {
       if(null==task.getId()){
           throw new IllegalArgumentException("Task id is null");
       }
       if(!Objects.equals(taskId,task.getId())){
           throw new IllegalArgumentException("id's do not match");
       }
       if(null==task.getTaskPriority()){
           throw new IllegalArgumentException("Task priority is null");
       }
       if(null==task.getTaskStatus()){
           throw new IllegalArgumentException("Task status is null");
       }

      Task existingtask =  taskRepository.findById(taskId).orElseThrow(()-> new IllegalArgumentException("Task  not found"));

       existingtask.setTitle(task.getTitle());
       existingtask.setDescription(task.getDescription());

       existingtask.setDueDate(task.getDueDate());
       existingtask.setTaskPriority(task.getTaskPriority());
       existingtask.setTaskStatus(task.getTaskStatus());
       existingtask.setUpdatedDate(LocalDateTime.now());

       return taskRepository.save(existingtask);


    }

    @Override
    public void deleteTask(UUID taskListId, UUID taskId) {
     taskRepository.deleteByTaskListIdAndId(taskListId,taskId);
    }
}
