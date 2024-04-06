package co.ufps.edu.projectservice.domain.useCase;

import co.ufps.edu.projectservice.domain.model.Project;
import co.ufps.edu.projectservice.domain.model.gateways.ProjectGateway;

import java.util.List;

public class ProjectUseCase {

    private final ProjectGateway gateway;

    public ProjectUseCase(ProjectGateway gateway) {
        this.gateway = gateway;
    }

    public Project saveProject(Project project) {return gateway.save(project);}

    public Project findProjectById(Long id){return gateway.findById(id);}

    public void deleteProjectById(Long id){ gateway.deleteByID(id);}

    public List<Project> findAllProjects(){return gateway.findAllProjects();}

    public List<Project>findAllProjectsById(List<Long>projectsId){return gateway.findProjectsById(projectsId);}
}
