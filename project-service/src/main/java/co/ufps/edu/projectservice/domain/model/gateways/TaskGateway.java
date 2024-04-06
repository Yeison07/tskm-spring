package co.ufps.edu.projectservice.domain.model.gateways;

import co.ufps.edu.projectservice.domain.model.Status;
import co.ufps.edu.projectservice.domain.model.Task;

import java.util.List;

public interface TaskGateway {
    Task save(Task task);
    void deleteByID(Long id);
    Task findById(Long id);
    List<Task> findAllTasks();
    List<Task>findAllTasksById(Long taskId);
    void updateTaskStatus(Status status, Long id);
}
