package my.personal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.personal.dao.impl.ScheduleRepo;
import my.personal.entity.TaskHistory;

import java.sql.Date;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    public ScheduleRepo scheduleRepo;

    public List<TaskHistory> getTaskHistory(String taskName) {
        return scheduleRepo.getTaskHistory(taskName);
    }

    public List<TaskHistory> getDayBatchHistory(Date startDate, Date endDate) {
        return scheduleRepo.getDayBatchHistory(startDate, endDate);
    }
}