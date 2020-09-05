package my.personal.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import my.personal.entity.TaskHistory;

@Repository
public class ScheduleRepo {
    @PersistenceContext
    EntityManager entityManager;

    public void addTodaySchedule(final List<TaskHistory> todaysScheduleList) throws Exception {
        try{
            for(TaskHistory schedule: todaysScheduleList){
                entityManager.persist(schedule);
            }
        }   catch(Exception e){
            e.printStackTrace();
            throw new Exception("Could not add today's schedule");
        }
    }

    public List<TaskHistory> getTaskHistory(final String taskName){
        final Query q = entityManager.createNativeQuery("select * from ijournal.schedule_hist WHERE task = ?", TaskHistory.class);
        q.setParameter(1, taskName);

        return q.getResultList();
    }

    public List<TaskHistory> getDayBatchHistory(final Date startDate, final Date endDate){
        final Query q = entityManager.createNativeQuery("select * from ijournal.schedule_hist WHERE date BETWEEN ? AND ?", TaskHistory.class);
        q.setParameter(1, startDate);
        q.setParameter(2, endDate);

        return q.getResultList();
    }
}