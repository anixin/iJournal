package my.personal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.personal.dao.impl.ScheduleRepo;
import my.personal.entity.TaskHistory;

import java.sql.Date;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    public ScheduleRepo scheduleRepo;

    @Transactional
    public void addTodaySchedule (final List<TaskHistory> todaysScheduleList) throws Exception{
        scheduleRepo.addTodaySchedule(todaysScheduleList);
    }

    public List<TaskHistory> getTaskHistory(String taskName) {
        return scheduleRepo.getTaskHistory(taskName);
    }

    public List<TaskHistory> getDayBatchHistory(Date startDate, Date endDate) {
        return scheduleRepo.getDayBatchHistory(startDate, endDate);
    }

    @Transactional
    public void updateTasks(final List<TaskHistory> taskList) throws Exception {
        scheduleRepo.updateTasks(taskList);
    }
    
    public String getWorkToDo(String taskCategory){
        return scheduleRepo.getWorkToDo(taskCategory);
    }
}