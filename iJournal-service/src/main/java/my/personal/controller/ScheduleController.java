package my.personal.controller;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import my.personal.entity.TaskHistory;
import my.personal.service.ScheduleService;

@CrossOrigin
@Controller
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping(value = "/addTodaysSchedule", consumes = MediaType.APPLICATION_JSON, produces = MediaType.TEXT_PLAIN)
    public ResponseEntity<Object> addTodaySchedule(@RequestBody List<TaskHistory> todaysScheduleList) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            scheduleService.addTodaySchedule(todaysScheduleList);
            return new ResponseEntity<>(mapper.writeValueAsString("Tasks Saved"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/getTaskHistory/{taskName}")
    public ResponseEntity<Object> getTaskHistory(@PathVariable String taskName) {
        return new ResponseEntity<>(scheduleService.getTaskHistory(taskName), HttpStatus.OK);
    }

    @GetMapping(value = "/getDayBatchHistory")
    public ResponseEntity<Object> getDayBatchHistory(@RequestBody Date startDate, @RequestBody Date endDate) {
        return new ResponseEntity<>(scheduleService.getDayBatchHistory(startDate, endDate), HttpStatus.OK);
    }

    @PostMapping(value = "/updateTasks")
    public ResponseEntity<Object> updateTasks(@RequestBody final List<TaskHistory> taskList){
        ObjectMapper mapper = new ObjectMapper();
        try{
            scheduleService.updateTasks(taskList);
            return new ResponseEntity<>(mapper.writeValueAsString("Tasks Saved"), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    } 

    @GetMapping(value = "/getWorkToDo")
    public ResponseEntity<Object> getWorkToDo(@QueryParam("taskCategory") String taskCategory) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            String response = scheduleService.getWorkToDo(taskCategory);
            return new ResponseEntity<>(mapper.writeValueAsString(response) , HttpStatus.OK);
        }   catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}