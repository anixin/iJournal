package my.personal.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "schedule_hist")
public class TaskHistory implements Serializable {
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
    @Column(name = "to_do")
    private String toDo;
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

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    

}