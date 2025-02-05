package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.VehicleDto;
import backend.apiestacionamento.dto.VehicleLogDto;
import backend.apiestacionamento.model.Vehicle;
import backend.apiestacionamento.model.VehicleLog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    VehicleDto vehicleToDto(Vehicle vehicle);

    Vehicle ToEntityVehicleLog(VehicleDto vehicleDto);
}
