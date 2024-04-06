package co.ufps.edu.projectservice.domain.useCase;

import co.ufps.edu.projectservice.domain.model.Status;
import co.ufps.edu.projectservice.domain.model.Task;
import co.ufps.edu.projectservice.domain.model.gateways.TaskGateway;

import java.util.List;

public class TaskUseCase {

    private final TaskGateway gateway;

    public TaskUseCase(TaskGateway gateway) {
        this.gateway = gateway;
    }

    public Task saveTask(Task task) {return gateway.save(task);}

    public Task findTaskById(Long id){return gateway.findById(id);}

    public void deleteTaskById(Long id){ gateway.deleteByID(id);}

    public List<Task> findAllTasks(){return gateway.findAllTasks();}

    public List<Task>findAllTaskById(Long taskId){return gateway.findAllTasksById(taskId);}

    public void updateTaskStatus(Status status, Long id){ gateway.updateTaskStatus(status,id);}

}
