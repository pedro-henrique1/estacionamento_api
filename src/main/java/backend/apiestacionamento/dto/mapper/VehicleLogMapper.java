package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.EstablishmentDto;
import backend.apiestacionamento.dto.VehicleLogDto;
import backend.apiestacionamento.model.Establishment;
import backend.apiestacionamento.model.VehicleLog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface VehicleLogMapper {

    VehicleLogDto vehicleToDto(VehicleLog vehicleLog);

    VehicleLog ToEntityVehicleLog(VehicleLogDto vehicleLogDto);

}
