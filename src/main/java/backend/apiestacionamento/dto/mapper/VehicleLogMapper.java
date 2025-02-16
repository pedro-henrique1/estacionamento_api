package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.VehicleLogRecord;
import backend.apiestacionamento.model.VehicleLog;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface VehicleLogMapper {

    //    @Mapping(source = "establishment.id", target = "establishment")
//    @Mapping(source = "vehicle.id", target = "vehicle")
    VehicleLogRecord vehicleToDto(VehicleLog vehicleLog);

    //    @Mapping(source = "establishment", target = "establishment.id")
//    @Mapping(source = "vehicle", target = "vehicle.id")
    VehicleLog ToEntityVehicleLog(VehicleLogRecord vehicleLogRecord);

}
