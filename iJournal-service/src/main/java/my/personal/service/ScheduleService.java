package my.personal.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.personal.dao.impl.ScheduleRepo;
import my.personal.entity.DayHistory;
import my.personal.entity.TaskHistory;

@Service
public class ScheduleService {
    @Autowired
    public ScheduleRepo scheduleRepo;

    @Transactional
    public void addTodaySchedule(final List<TaskHistory> todaysScheduleList) throws Exception {
        scheduleRepo.addTodaySchedule(todaysScheduleList);
    }

    public List<TaskHistory> getTodaySchedule(Date date){
        return scheduleRepo.getTodaySchedule(date);
    }

    public List<TaskHistory> getTaskHistory(String taskName) {
        return scheduleRepo.getTaskHistory(taskName);
    }

    public List<DayHistory> getDayBatchHistory(Date startDate, Date endDate) {
        Map<Date, List<TaskHistory>> map = new HashMap<>();
        List<DayHistory> res = new ArrayList<>();

        List<TaskHistory> taskHistoryList = scheduleRepo.getDayBatchHistory(startDate, endDate);

        for (TaskHistory taskHistory : taskHistoryList) {
            if(map.containsKey(taskHistory.getDate())){
                map.get(taskHistory.getDate()).add(taskHistory);
            }   else{
                List<TaskHistory> tasksForDate = new ArrayList<>();
                tasksForDate.add(taskHistory);
                map.put(taskHistory.getDate(), tasksForDate);
            }
        }

        for(Entry<Date, List<TaskHistory>> ent: map.entrySet()){
            DayHistory mand = new DayHistory();
            mand.setDate(ent.getKey());
            mand.setTasks(ent.getValue());

            res.add(mand);
        }

        return res;
    }

    @Transactional
    public void updateTasks(final List<TaskHistory> taskList) throws Exception {
        scheduleRepo.updateTasks(taskList);
    }

    public String getWorkToDo(String taskCategory) {
        return scheduleRepo.getWorkToDo(taskCategory);
    }
}