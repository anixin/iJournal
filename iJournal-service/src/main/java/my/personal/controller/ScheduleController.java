package my.personal.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import my.personal.service.ScheduleService;

@Controller
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(value = "/getTaskHistory")
    public ResponseEntity<Object> getTaskHistory(@RequestBody String taskName) {
        return new ResponseEntity<>(scheduleService.getTaskHistory(taskName), HttpStatus.OK);
    }

    @GetMapping(value = "/getDayBatchHistory")
    public ResponseEntity<Object> getDayBatchHistory(@RequestBody Date startDate, @RequestBody Date endDate) {
        return new ResponseEntity<>(scheduleService.getDayBatchHistory(startDate, endDate), HttpStatus.OK);
    }
}