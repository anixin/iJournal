package my.personal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import my.personal.entity.Task;

@Repository
public class TaskRepoImpl{

    @PersistenceContext
    EntityManager entityManager;

    public void addTask(Task task) {
        Query q = entityManager.createNativeQuery("Insert into ijournal.task(task_name,description) values(?,?) ");
        q.setParameter(1, task.getTaskName());
        q.setParameter(2, task.getDescription());
        q.executeUpdate();
    }

    public List<Task> getTasks() {
        Query q = entityManager.createNativeQuery("select id, task_name, description from ijournal.task", Task.class);

        return q.getResultList();
    }

}