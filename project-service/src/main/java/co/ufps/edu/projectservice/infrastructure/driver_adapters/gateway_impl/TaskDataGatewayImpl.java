package co.ufps.edu.projectservice.infrastructure.driver_adapters.gateway_impl;

import co.ufps.edu.projectservice.domain.model.Status;
import co.ufps.edu.projectservice.domain.model.Task;
import co.ufps.edu.projectservice.domain.model.gateways.TaskGateway;
import co.ufps.edu.projectservice.infrastructure.driver_adapters.jpa_repository.TaskDataJpaRepository;
import co.ufps.edu.projectservice.infrastructure.mapper.MapperStatus;
import co.ufps.edu.projectservice.infrastructure.mapper.MapperTask;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TaskDataGatewayImpl implements TaskGateway {

    private final TaskDataJpaRepository repository;
    private final MapperTask mapperTask;
    private final MapperStatus mapperStatus;

    public TaskDataGatewayImpl(TaskDataJpaRepository repository, MapperTask mapperTask, MapperStatus mapperStatus) {
        this.repository = repository;
        this.mapperTask = mapperTask;
        this.mapperStatus = mapperStatus;
    }

    @Override
    public Task save(Task task) {
        if (task == null) return null;
        var taskData = mapperTask.toTaskData(task);
        return mapperTask.toTask(repository.save(taskData));
    }

    @Override
    public void deleteByID(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Task findById(Long id) {
        return mapperTask.toTask(repository.findById(id).orElse(null));
    }

    @Override
    public List<Task> findAllTasks() {
        return mapperTask.toListTask(repository.findAll());
    }

    @Override
    public List<Task> findAllTasksById(Long taskId) {
        return mapperTask.toListTask(repository.findAllById(taskId));
    }

    @Override
    @Transactional
    public void updateTaskStatus(Status status, Long id) {
        repository.updateTaskState(mapperStatus.toStatusData(status), id);

    }
}
