package my.personal.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import my.personal.entity.TaskHistory;
import my.personal.service.ScheduleService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping(value = "/addTodaysScheule")
    public ResponseEntity<Object> addTodaySchedule(@RequestBody List<TaskHistory> todaysScheduleList) {
        try {
            scheduleService.addTodaySchedule(todaysScheduleList);
            return new ResponseEntity<>("Schedules added successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/getTaskHistory")
    public ResponseEntity<Object> getTaskHistory(@RequestBody String taskName) {
        return new ResponseEntity<>(scheduleService.getTaskHistory(taskName), HttpStatus.OK);
    }

    @GetMapping(value = "/getDayBatchHistory")
    public ResponseEntity<Object> getDayBatchHistory(@RequestBody Date startDate, @RequestBody Date endDate) {
        return new ResponseEntity<>(scheduleService.getDayBatchHistory(startDate, endDate), HttpStatus.OK);
    }
}