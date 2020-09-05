package my.personal.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "task")
    private String taskName;
    @Column(name = "date")
    private Date date;
    @Column(name = "committed_time_mins")
    private int timeCommitted;
    @Column(name = "actual_time_mins")
    private int actualTime;
    @Column(name = "work_done")
    private String workDone;
    @Column(name = "work_for_next_time")
    private String toBeDoneNext;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTimeCommitted() {
        return timeCommitted;
    }

    public void setTimeCommitted(int timeCommitted) {
        this.timeCommitted = timeCommitted;
    }

    public int getActualTime() {
        return actualTime;
    }

    public void setActualTime(int actualTime) {
        this.actualTime = actualTime;
    }

    public String getWorkDone() {
        return workDone;
    }

    public void setWorkDone(String workDone) {
        this.workDone = workDone;
    }

    public String getToBeDoneNext() {
        return toBeDoneNext;
    }

    public void setToBeDoneNext(String toBeDoneNext) {
        this.toBeDoneNext = toBeDoneNext;
    }

    

}