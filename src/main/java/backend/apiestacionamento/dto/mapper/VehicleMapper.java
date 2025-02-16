package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.VehicleDto;
import backend.apiestacionamento.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface VehicleMapper {

    @Mapping(source = "created_at", target = "created_at")
    @Mapping(source = "updated_at", target = "updated_at")
    @Mapping(source = "establishment.id", target = "establishment")
    VehicleDto vehicleToDto(Vehicle vehicle);

    @Mapping(source = "created_at", target = "created_at")
    @Mapping(source = "updated_at", target = "updated_at")
    @Mapping(source = "establishment", target = "establishment.id")
    Vehicle ToEntityVehicle(VehicleDto vehicleDto);
}
