package com.Task.Task.Domain.DTO;

import com.Task.Task.Domain.Entities.TaskPriority;
import com.Task.Task.Domain.Entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(

        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status

) {

}
