package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.VehicleRecord;
import backend.apiestacionamento.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleMapper {

//    @Mapping(source = "establishment", target = "establishment.id")
    VehicleRecord vehicleToDto(Vehicle vehicle);

//    @Mapping(source = "establishment.id", target = "establishment")
    Vehicle ToEntityVehicle(VehicleRecord vehicleRecord);

    void updateVehicle(VehicleRecord vehicleRecord, @MappingTarget Vehicle vehicle);
}
