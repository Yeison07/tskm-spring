package co.ufps.edu.projectservice.infrastructure.driver_adapters.data_entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task")
public class TaskData {

    @Id
    private Long id;
    private String title;
    private String description;
    private String owner;
    @ManyToOne
    @JoinColumn(name = "status")
    private StatusData statusData;
    @ManyToMany
    @JoinTable(name = "projects_assignes",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "assigne_id"))
    private Set<AssigneesData> assigneesData = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectData projectData;

    public TaskData() {
    }

    public TaskData(Long id, String title, String description, String owner, StatusData statusData, Set<AssigneesData> assigneesData) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.statusData = statusData;
        this.assigneesData = assigneesData;
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

    public StatusData getStatusData() {
        return statusData;
    }

    public void setStatusData(StatusData statusData) {
        this.statusData = statusData;
    }

    public Set<AssigneesData> getAssigneesData() {
        return assigneesData;
    }

    public void setAssigneesData(Set<AssigneesData> assigneesData) {
        this.assigneesData = assigneesData;
    }
}
