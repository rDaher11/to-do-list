package models;

import java.time.LocalDate;

public class Task {
    private Integer id ;
    private String description ;
    private Status status ;
    private LocalDate createAt ;
    private LocalDate updateAt ;

    public Task() {}

    public Task(Integer id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createAt = LocalDate.now();
        this.updateAt = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
