package co.ufps.edu.projectservice.application.config;

import co.ufps.edu.projectservice.domain.model.gateways.ProjectGateway;
import co.ufps.edu.projectservice.domain.model.gateways.TaskGateway;
import co.ufps.edu.projectservice.domain.useCase.ProjectUseCase;
import co.ufps.edu.projectservice.domain.useCase.TaskUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ProjectUseCase projectUseCase(ProjectGateway gateway){
        return new ProjectUseCase(gateway);
    }

    @Bean
    public TaskUseCase taskUseCase(TaskGateway gateway){
        return new TaskUseCase(gateway);
    }


}
