package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.VehicleDto;
import backend.apiestacionamento.model.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    VehicleDto vehicleToDto(Vehicle vehicle);

    Vehicle ToEntityVehicle(VehicleDto vehicleDto);
}
