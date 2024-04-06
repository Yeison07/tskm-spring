package co.ufps.edu.projectservice.infrastructure.mapper;

import co.ufps.edu.projectservice.domain.model.Status;
import co.ufps.edu.projectservice.infrastructure.driver_adapters.data_entities.StatusData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperStatus {

    Status toStatus(StatusData statusData);
    StatusData toStatusData(Status status);
}
