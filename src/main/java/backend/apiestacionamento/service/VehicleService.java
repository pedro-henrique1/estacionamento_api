package backend.apiestacionamento.service;


import backend.apiestacionamento.dto.VehicleDto;
import backend.apiestacionamento.dto.mapper.VehicleMapper;
import backend.apiestacionamento.model.Vehicle;
import backend.apiestacionamento.repository.VehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public VehicleService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    public ResponseEntity<VehicleDto> saveVehicle(VehicleDto vehicle) {
        if (vehicle != null) {
            vehicleRepository.save(vehicleMapper.ToEntityVehicle(vehicle));
            return ResponseEntity.ok(vehicle);
        }
        return ResponseEntity.badRequest().build();
    }


    public ResponseEntity<VehicleDto> updateVehicle(VehicleDto vehicle) {
        Vehicle vehicleDto = vehicleRepository.findById(vehicle.getId()).orElseThrow(() -> new RuntimeException("vehicle not found"));
        vehicleDto.setColor(vehicle.getColor());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setMark(vehicle.getMark());
        vehicleDto.setType(vehicle.getType());
        vehicleDto.setPlate(vehicle.getPlate());
        vehicleRepository.save(vehicleDto);
        return ResponseEntity.ok(vehicleMapper.vehicleToDto(vehicleDto));
    }

    public ResponseEntity<VehicleDto> deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("vehicle not found"));
        vehicleRepository.delete(vehicle);
        return ResponseEntity.ok(vehicleMapper.vehicleToDto(vehicle));
    }

    public ResponseEntity<List<VehicleDto>> findAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return ResponseEntity.ok(vehicles.stream().map(vehicleMapper::vehicleToDto).collect(Collectors.toList()));
    }

    public ResponseEntity<VehicleDto> findVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("vehicle not found"));
        return ResponseEntity.ok(vehicleMapper.vehicleToDto(vehicle));
    }
}
