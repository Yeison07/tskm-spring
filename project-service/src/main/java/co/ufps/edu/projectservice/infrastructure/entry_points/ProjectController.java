package co.ufps.edu.projectservice.infrastructure.entry_points;

import co.ufps.edu.projectservice.domain.model.Project;
import co.ufps.edu.projectservice.domain.model.Task;
import co.ufps.edu.projectservice.domain.useCase.ProjectUseCase;
import co.ufps.edu.projectservice.domain.useCase.TaskUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@CrossOrigin
public class ProjectController {

    private final ProjectUseCase projectUseCase;
    private final TaskUseCase taskUseCase;

    public ProjectController(ProjectUseCase projectUseCase, TaskUseCase taskUseCase) {
        this.projectUseCase = projectUseCase;
        this.taskUseCase = taskUseCase;
    }

    @RequestMapping(path = "/registerNewProject",method = RequestMethod.POST)
    public ResponseEntity<Object>registerNewProject(@RequestBody Project project){
        if (project==null){
            String message="The project submit is empty or has incomplete fields";
            return new ResponseEntity<>(message,HttpStatus.CREATED);

        }

        return new ResponseEntity<>(projectUseCase.saveProject(project),HttpStatus.CREATED);
    }

    @RequestMapping(path = "/getAllProjects",method = RequestMethod.GET)
    public ResponseEntity<Object> findAllProjects(){
        var projects=projectUseCase.findAllProjects();
        if (projects==null){
            String message="The requested resource was not found";
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects,HttpStatus.OK);
    }

    @RequestMapping(path = "/getProjectById/{id}",method = RequestMethod.GET)
    public ResponseEntity<Object> findAllProjects(@PathVariable Long id){
        var projects=projectUseCase.findAllProjects();
        if (projects==null){
            String message="The requested resource was not found";
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects,HttpStatus.OK);
    }

    @RequestMapping(path = "/getAllProjectsById",method = RequestMethod.POST)
    public ResponseEntity<Object> findAllProjectsById(@RequestBody List<Long>projectsId){
        System.err.println(projectsId);
        var projects=projectUseCase.findAllProjectsById(projectsId);
        if (projects==null){
            String message="The requested resource was not found";
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects,HttpStatus.OK);
    }

    @RequestMapping(path = "/getAllTasksById",method = RequestMethod.POST)
    public ResponseEntity<Object> findAllTaskByProject(@RequestBody Long taskId){
        var tasks=taskUseCase.findAllTaskById(taskId);
        if (tasks==null){
            String message="The requested resource was not found";
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tasks,HttpStatus.OK);
    }

    @RequestMapping(path = "/getAllTasks",method = RequestMethod.GET)
    public ResponseEntity<Object> findAllTask(){
        var tasks=taskUseCase.findAllTasks();
        if (tasks==null){
            String message="The requested resource was not found";
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tasks,HttpStatus.OK);
    }

    @RequestMapping(path = "/updateTaskState",method = RequestMethod.PUT)
    public ResponseEntity<Object> updateTaskState(@RequestBody Task task){
        if (task==null || task.getId()==null || task.getStatus()==null){
            String message="Bad request";
            return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
        }
        taskUseCase.updateTaskStatus(task.getStatus(),task.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
