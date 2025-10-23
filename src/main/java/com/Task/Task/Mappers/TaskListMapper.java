package com.Task.Task.Mappers;

import com.Task.Task.Domain.DTO.TaskListDto;
import com.Task.Task.Domain.Entities.TaskList;

public interface TaskListMapper {
   TaskList fromDto(TaskListDto taskListDto);

   TaskListDto toDto(TaskList taskList);

}
