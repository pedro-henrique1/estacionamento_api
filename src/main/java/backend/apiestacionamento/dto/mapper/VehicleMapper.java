package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.VehicleRecord;
import backend.apiestacionamento.model.Establishment;
import backend.apiestacionamento.model.Vehicle;
import org.mapstruct.*;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface VehicleMapper {

    @Mapping(target = "establishment", source = "establishment")
    VehicleRecord vehicleToDto(Vehicle vehicle);

    //    @Mapping(source = "establishment.id", target = "establishment")
    @Mapping(target = "establishment", source = "establishment")
    Vehicle ToEntityVehicle(VehicleRecord vehicleRecord);

    void updateVehicle(VehicleRecord vehicleRecord, @MappingTarget Vehicle vehicle);

    default Long map(Establishment establishment) {
        return establishment != null ? establishment.getId() : null;
    }

    default Establishment map(Long id) {
        if (id == null) {
            return null;
        }
        Establishment establishment = new Establishment();
        establishment.setId(id);
        return establishment;
    }
}
