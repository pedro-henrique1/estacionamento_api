package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.EstablishmentDto;
import backend.apiestacionamento.dto.VehicleDto;
import backend.apiestacionamento.dto.VehicleLogDto;
import backend.apiestacionamento.model.Establishment;
import backend.apiestacionamento.model.Vehicle;
import backend.apiestacionamento.model.VehicleLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)

public interface VehicleLogMapper {


    @Mapping(source = "establishment.id", target = "establishment")
    @Mapping(source = "vehicle.id", target = "vehicle")
    VehicleLogDto vehicleToDto(VehicleLog vehicleLog);

    @Mapping(source = "establishment", target = "establishment.id")
    @Mapping(source = "vehicle", target = "vehicle.id")
    VehicleLog ToEntityVehicleLog(VehicleLogDto vehicleLogDto);

}
