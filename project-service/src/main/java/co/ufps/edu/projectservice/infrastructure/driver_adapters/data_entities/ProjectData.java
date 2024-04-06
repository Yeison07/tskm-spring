package co.ufps.edu.projectservice.infrastructure.driver_adapters.data_entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "project")
public class ProjectData {

    @Id
    private Long id;
    @Column(length = 100,nullable = false)
    private String title;
    @Column(length = 500,nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDateTime dateCreation;
    private LocalDateTime dateFinished;

    public ProjectData() {
    }

    public ProjectData(Long id, String title, String description, LocalDateTime dateCreation, LocalDateTime dateFinished) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateCreation = dateCreation;
        this.dateFinished = dateFinished;
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

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(LocalDateTime dateFinished) {
        this.dateFinished = dateFinished;
    }
}
