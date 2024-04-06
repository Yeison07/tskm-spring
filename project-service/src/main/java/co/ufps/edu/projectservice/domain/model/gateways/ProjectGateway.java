package co.ufps.edu.projectservice.domain.model.gateways;

import co.ufps.edu.projectservice.domain.model.Project;

import java.util.List;

public interface ProjectGateway {
    Project save(Project project);
    void deleteByID(Long id);
    Project findById(Long id);
    List<Project> findAllProjects();
    List<Project> findProjectsById(List<Long> projectsId);
}
