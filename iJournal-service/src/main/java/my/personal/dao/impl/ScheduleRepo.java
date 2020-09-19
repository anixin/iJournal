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
        try {
            for (TaskHistory schedule : todaysScheduleList) {
                entityManager.persist(schedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Could not add today's schedule");
        }
    }

    public List<TaskHistory> getTodaySchedule(Date date){
        Query q = entityManager.createNativeQuery("select * from ijournal.schedule_hist WHERE date = ?",
                TaskHistory.class);

        q.setParameter(1, date);
        return q.getResultList();
    }

    public List<TaskHistory> getTaskHistory(final String taskName) {
        final Query q = entityManager.createNativeQuery("select * from ijournal.schedule_hist WHERE task = ?",
                TaskHistory.class);
        q.setParameter(1, taskName);

        return q.getResultList();
    }

    public List<TaskHistory> getDayBatchHistory(final Date startDate, final Date endDate) {
        final Query q = entityManager.createNativeQuery(
                "select * from ijournal.schedule_hist WHERE date BETWEEN ? AND ? order by date", TaskHistory.class);
        q.setParameter(1, startDate);
        q.setParameter(2, endDate);

        return q.getResultList();
    }

    public void updateTasks(final List<TaskHistory> taskList) throws Exception {
        try {
            Query q = entityManager.createNativeQuery(
                    "UPDATE ijournal.schedule_hist SET work_for_next_time= ?, work_done=? WHERE date = ? AND task = ?");

            for (TaskHistory task : taskList) {
                q.setParameter(1, task.getToBeDoneNext());
                q.setParameter(2, task.getWorkDone());
                q.setParameter(3, task.getDate());
                q.setParameter(4, task.getTaskName());

                q.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error updating data");
        }

    }

    public String getWorkToDo(String taskCategory){
        Query q = entityManager.createNativeQuery("select work_for_next_time from schedule_hist where task = ? order by date desc limit 1");
        q.setParameter(1, taskCategory);
        return q.getSingleResult().toString();

    }
}