package co.ufps.edu.projectservice.infrastructure.mapper;

import co.ufps.edu.projectservice.domain.model.Task;
import co.ufps.edu.projectservice.infrastructure.driver_adapters.data_entities.TaskData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperTask {
    @Mapping(source = "statusData",target = "status")
    Task toTask(TaskData taskData);
    @Mapping(source = "status",target = "statusData")
    TaskData toTaskData(Task task);
    @Mapping(source = "statusData",target = "status")
    List<Task>toListTask(List<TaskData>taskDataList);
    @Mapping(source = "status",target = "statusData")
    List<TaskData>toListTaskData(List<Task>taskList);


}
