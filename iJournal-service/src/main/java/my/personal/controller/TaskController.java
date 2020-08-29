package my.personal.controller;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import my.personal.entity.Task;
import my.personal.service.TaskService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    @GetMapping(value ="/getAllTasks")
    public ResponseEntity<Object> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping(value="/addTask")
    public ResponseEntity<Object> addTask(@RequestBody Task task) {
        try{
            taskService.addTask(task);
            return new ResponseEntity<>("Task "+task.getTaskName()+" added succesfully", HttpStatus.OK);
        }   catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error while adding the task: " + task.getTaskName(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

}