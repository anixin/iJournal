package my.personal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import my.personal.entity.Task;
import my.personal.service.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/getAllTasks")
    public ResponseEntity<Object> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @PostMapping(value = "/addTask")
    public ResponseEntity<Object> addTask(@RequestBody Task task) {
        try {
            taskService.addTask(task);
            return new ResponseEntity<>("Task " + task.getTaskName() + " added succesfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error while adding the task: " + task.getTaskName(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}