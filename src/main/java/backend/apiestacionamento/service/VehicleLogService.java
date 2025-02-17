package backend.apiestacionamento.service;


import backend.apiestacionamento.dto.VehicleLogRecord;
import backend.apiestacionamento.dto.mapper.VehicleLogMapper;
import backend.apiestacionamento.exception.ParkingFullException;
import backend.apiestacionamento.model.VehicleLog;
import backend.apiestacionamento.repository.VehicleLogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class VehicleLogService {

    private final VehicleLogRepository vehicleLogRepository;
    private final VehicleLogMapper vehicleLogMapper;
    private final EstablishmentService establishmentService;

    public VehicleLogService(VehicleLogRepository vehicleLogRepository, VehicleLogMapper vehicleLogMapper, EstablishmentService establishmentService) {
        this.vehicleLogRepository = vehicleLogRepository;
        this.vehicleLogMapper = vehicleLogMapper;
        this.establishmentService = establishmentService;
    }

    public ResponseEntity<?> save(VehicleLogRecord vehicleLog) {
        if (establishmentService.isCarParkingFull(vehicleLog.establishment()) ||
                establishmentService.isMotorcycleParkingFull(vehicleLog.establishment())) {
            throw new ParkingFullException("Parking Full");
        }
        vehicleLogRepository.save(vehicleLogMapper.ToEntityVehicleLog(vehicleLog));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<?> exitTime(VehicleLogRecord vehicleLog, Long id) {
        VehicleLog existingVehicleLog = vehicleLogRepository.findById(id).orElseThrow(() -> new RuntimeException("vehicle not found"));

        if (vehicleLog.exitTime().isBefore(existingVehicleLog.getEntryTime())) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }

        existingVehicleLog.setExitTime(vehicleLog.exitTime());
        vehicleLogRepository.save(existingVehicleLog);
        return ResponseEntity.ok(vehicleLogMapper.vehicleToDto(existingVehicleLog));
    }


}
