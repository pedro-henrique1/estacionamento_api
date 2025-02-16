package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.VehicleLogRecord;
import backend.apiestacionamento.model.Establishment;
import backend.apiestacionamento.model.Vehicle;
import backend.apiestacionamento.model.VehicleLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface VehicleLogMapper {

    @Mapping(source = "establishment", target = "establishment")
    @Mapping(source = "vehicle", target = "vehicle")
    VehicleLogRecord vehicleToDto(VehicleLog vehicleLog);

    @Mapping(source = "establishment", target = "establishment")
    @Mapping(source = "vehicle", target = "vehicle")
    VehicleLog ToEntityVehicleLog(VehicleLogRecord vehicleLogRecord);

    default Long map(Establishment establishment) {
        return establishment != null ? establishment.getId() : null;
    }

    default Long map(Vehicle vehicle) {
        return vehicle != null ? vehicle.getId() : null;
    }

    default Establishment map(Long id) {
        if (id == null) {
            return null;
        }
        Establishment establishment = new Establishment();
        establishment.setId(id);
        return establishment;
    }

    default Vehicle map2(Long id) {
        if (id == null) {
            return null;
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        return vehicle;
    }
}
