package co.ufps.edu.projectservice.infrastructure.mapper;

import co.ufps.edu.projectservice.domain.model.Project;
import co.ufps.edu.projectservice.infrastructure.driver_adapters.data_entities.ProjectData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperProject {

    Project toProject(ProjectData projectData);
    ProjectData toProjectData(Project project);
    List<Project> toListProject(List<ProjectData> projectDataList);
    List<ProjectData> toListProjectData(List<Project> projectList);

}
