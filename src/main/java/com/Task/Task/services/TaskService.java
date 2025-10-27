package com.Task.Task.services;

import com.Task.Task.Domain.Entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
List<Task> listTasks(UUID taskListId);
}


