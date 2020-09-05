package my.personal.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import my.personal.entity.Task;
import my.personal.entity.TaskHistory;

@Repository
public class ScheduleRepo {
    @PersistenceContext
    EntityManager entityManager;

    public List<TaskHistory> getTaskHistory(String taskName){
        Query q = entityManager.createNativeQuery("select * from ijournal.schedule_hist WHERE task = ?", TaskHistory.class);
        q.setParameter(1, taskName);

        return q.getResultList();
    }

    public List<TaskHistory> getDayBatchHistory(Date startDate, Date endDate){
        Query q = entityManager.createNativeQuery("select * from ijournal.schedule_hist WHERE date BETWEEN ? AND ?", TaskHistory.class);
        q.setParameter(1, startDate);
        q.setParameter(2, endDate);

        return q.getResultList();
    }
}