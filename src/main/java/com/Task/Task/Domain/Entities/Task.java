package com.Task.Task.Domain.Entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id",updatable = false,nullable  = false)
    private UUID id;

    @Column(name = "title",nullable  = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "status",nullable = false)
    private TaskStatus taskStatus;

    @Column(name = "priority",nullable = false)
    private TaskPriority taskPriority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_list_id")
    private TaskList taskList;

    @Column(name = "created",nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated",nullable = false)
    private  LocalDateTime updatedDate;

    public Task() {
    }

    public Task(UUID id, String description, String title, LocalDateTime dueDate, TaskStatus taskStatus, TaskPriority taskPriority, TaskList taskList, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.dueDate = dueDate;
        this.taskStatus = taskStatus;
        this.taskPriority = taskPriority;
        this.taskList = taskList;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(dueDate, task.dueDate) && taskStatus == task.taskStatus && taskPriority == task.taskPriority && Objects.equals(taskList, task.taskList) && Objects.equals(createdDate, task.createdDate) && Objects.equals(updatedDate, task.updatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dueDate, taskStatus, taskPriority, taskList, createdDate, updatedDate);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", taskStatus=" + taskStatus +
                ", taskPriority=" + taskPriority +
                ", taskList=" + taskList +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
