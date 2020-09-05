package my.personal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.personal.dao.impl.TaskRepoImpl;
import my.personal.entity.Task;

@Service
public class TaskService {
    @Autowired
    public TaskRepoImpl taskRepo;

    @Transactional
    public void addTask(Task task) {
        taskRepo.addTask(task);
    }

    public List<Task> getAllTasks() {
        return taskRepo.getTasks();
    }
}