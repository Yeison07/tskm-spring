package co.ufps.edu.projectservice.domain.model;

import java.util.List;

public class Task {

    private Long id;
    private String title;
    private String description;
    private String owner;
    private Status status;
    private List<String> assignees;

    public Task() {
    }

    public Task(Long id, String title, String description, String owner, Status status, List<String> assignees) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.status = status;
        this.assignees = assignees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<String> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<String> assignees) {
        this.assignees = assignees;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", owner='" + owner + '\'' +
                ", status=" + status +
                ", assignees=" + assignees +
                '}';
    }
}
