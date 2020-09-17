package my.personal.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class DayHistory implements Serializable{
    private Date date;
    private List<TaskHistory> tasks;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<TaskHistory> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskHistory> tasks) {
        this.tasks = tasks;
    }

    
}
