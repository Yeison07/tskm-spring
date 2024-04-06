package co.ufps.edu.projectservice.infrastructure.driver_adapters.jpa_repository;

import co.ufps.edu.projectservice.infrastructure.driver_adapters.data_entities.ProjectData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProjectDataJpaRepository extends JpaRepository <ProjectData,Long>{

    @Query(value = "SELECT p FROM ProjectData p WHERE p.id IN :projectsIds")
    List<ProjectData> projectsById(@Param("projectsIds")List<Long>projectsIds );
}
