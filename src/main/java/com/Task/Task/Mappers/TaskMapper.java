package com.Task.Task.Mappers;

import com.Task.Task.Domain.DTO.TaskDto;
import com.Task.Task.Domain.Entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);
}
