package backend.apiestacionamento.service;


import backend.apiestacionamento.dto.VehicleLogRecord;
import backend.apiestacionamento.dto.mapper.VehicleLogMapper;
import backend.apiestacionamento.model.VehicleLog;
import backend.apiestacionamento.repository.VehicleLogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class VehicleLogService {

    private final VehicleLogRepository vehicleLogRepository;
    private final VehicleLogMapper vehicleLogMapper;

    public VehicleLogService(VehicleLogRepository vehicleLogRepository, VehicleLogMapper vehicleLogMapper) {
        this.vehicleLogRepository = vehicleLogRepository;
        this.vehicleLogMapper = vehicleLogMapper;
    }

    public ResponseEntity<?> save(VehicleLogRecord vehicleLog) {
        vehicleLogRepository.save(vehicleLogMapper.ToEntityVehicleLog(vehicleLog));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<?> exitTime(VehicleLogRecord vehicleLog) {
        VehicleLog vehicleLog1 = vehicleLogRepository.findById(vehicleLog.id()).orElseThrow(() -> new RuntimeException("vehicle not found"));
        if (vehicleLog.entryTime().isBefore(vehicleLog1.getEntryTime())) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        vehicleLog1.setExitTime(vehicleLog.exitTime());
        vehicleLogRepository.save(vehicleLog1);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
