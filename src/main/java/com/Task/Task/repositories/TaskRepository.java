package com.Task.Task.repositories;


import com.Task.Task.Domain.Entities.Task;
import com.Task.Task.Domain.Entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    List<Task> findByTaskListId(UUID id);

    Optional<Task> findByTaskListIdAndId(UUID id, UUID taskListId);

    void deleteByTaskListIdAndId(UUID id, UUID taskListId);
}
