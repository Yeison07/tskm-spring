package co.ufps.edu.projectservice.infrastructure.driver_adapters.gateway_impl;

import co.ufps.edu.projectservice.domain.model.Project;
import co.ufps.edu.projectservice.domain.model.gateways.ProjectGateway;
import co.ufps.edu.projectservice.infrastructure.driver_adapters.data_entities.ProjectData;
import co.ufps.edu.projectservice.infrastructure.driver_adapters.jpa_repository.ProjectDataJpaRepository;
import co.ufps.edu.projectservice.infrastructure.mapper.MapperProject;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ProjectDataGatewayImpl implements ProjectGateway {

    private final MapperProject mapperProject;
    private final ProjectDataJpaRepository repository;

    public ProjectDataGatewayImpl(MapperProject mapperProject, ProjectDataJpaRepository repository) {
        this.mapperProject = mapperProject;
        this.repository = repository;
    }

    @Override
    public Project save(Project project) {
        if (project==null){
            return null;
        }
        ProjectData projectData=mapperProject.toProjectData(project);
        projectData.setDateCreation(LocalDateTime.now());
        return mapperProject.toProject(repository.save(projectData));
    }

    @Override
    public void deleteByID(Long id) {
         repository.deleteById(id);
    }

    @Override
    public Project findById(Long id) {
        var project=mapperProject.toProject(repository.findById(id).orElse(null));
        return project;
    }

    @Override
    public List<Project> findAllProjects() {
        return mapperProject.toListProject(repository.findAll());
    }

    @Override
    public List<Project> findProjectsById(List<Long> projectsId) {
        return mapperProject.toListProject(repository.projectsById(projectsId));
    }
}
