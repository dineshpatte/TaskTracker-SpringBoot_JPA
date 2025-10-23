package com.Task.Task.Mappers.impl;

import com.Task.Task.Domain.DTO.TaskDto;
import com.Task.Task.Domain.Entities.Task;
import com.Task.Task.Mappers.TaskMapper;
import org.springframework.stereotype.Component;


@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public Task fromDto(TaskDto taskDto) {
        return new  Task(
                taskDto.id(),
                taskDto.title(),
                taskDto.description(),
                taskDto.dueDate(),
                taskDto.status(),
                taskDto.priority(),
                null,
                null,
                null
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new  TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getTaskPriority(),
                task.getTaskStatus()
        );
    }
}
