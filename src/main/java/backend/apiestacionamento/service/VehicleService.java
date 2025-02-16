package backend.apiestacionamento.service;


import backend.apiestacionamento.dto.VehicleRecord;
import backend.apiestacionamento.dto.mapper.VehicleMapper;
import backend.apiestacionamento.model.Vehicle;
import backend.apiestacionamento.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    public VehicleService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;


    public ResponseEntity<VehicleRecord> saveVehicle(VehicleRecord vehicle) {
        if (vehicle != null) {
            Vehicle vehicleResponse = vehicleRepository.save(vehicleMapper.ToEntityVehicle(vehicle));
            return ResponseEntity.ok(vehicleMapper.vehicleToDto(vehicleResponse));
        }
        return ResponseEntity.badRequest().build();
    }


    public ResponseEntity<VehicleRecord> updateVehicle(VehicleRecord vehicle) {
        Vehicle vehicleDto = vehicleRepository.findById(vehicle.id()).orElseThrow(() -> new RuntimeException("vehicle not found"));
        vehicleMapper.updateVehicle(vehicle, vehicleDto);
        vehicleRepository.save(vehicleDto);
        return ResponseEntity.ok(vehicleMapper.vehicleToDto(vehicleDto));

    }

    public ResponseEntity<VehicleRecord> deleteVehicle(Integer id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("vehicle not found"));
        vehicleRepository.delete(vehicle);
        return ResponseEntity.ok(vehicleMapper.vehicleToDto(vehicle));
    }

    public ResponseEntity<List<VehicleRecord>> findAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return ResponseEntity.ok(vehicles.stream().map(vehicleMapper::vehicleToDto).collect(Collectors.toList()));
    }

    public ResponseEntity<VehicleRecord> findVehicleById(Integer id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("vehicle not found"));
        return ResponseEntity.ok(vehicleMapper.vehicleToDto(vehicle));
    }
}
