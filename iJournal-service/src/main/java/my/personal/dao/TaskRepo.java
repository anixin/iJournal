package my.personal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import my.personal.entity.Task;

@Repository
public interface TaskRepo    {
    void addTask(Task task);
    List<Task> getTasks();
}