package co.ufps.edu.projectservice.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Project {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime dateCreation;
    private LocalDateTime dateFinished;
    private List<Task>tasks;
    private Double projectPercentaje;

    public Project() {
    }

    public Project(String title, String description, LocalDateTime dateCreation, LocalDateTime dateFinished, List<Task> tasks, Double projectPercentaje) {
        this.title = title;
        this.description = description;
        this.dateCreation = dateCreation;
        this.dateFinished = dateFinished;
        this.tasks = tasks;
        this.projectPercentaje = projectPercentaje;
    }

    public void calculateProjectPercentaje(){
        Integer taskDone=0;
        for(Task task:this.tasks){
            if (task.getStatus().getId().equals(4)){
                taskDone++;
            }
        }
         this.projectPercentaje= (double) (taskDone/this.tasks.size());
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


    public Double getProjectPercentaje() {
        return projectPercentaje;
    }

    public void setProjectPercentaje(Double projectPercentaje) {
        this.projectPercentaje = projectPercentaje;
    }
}
