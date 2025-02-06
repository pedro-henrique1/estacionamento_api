package backend.apiestacionamento.service;


import backend.apiestacionamento.dto.VehicleLogDto;
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

    public ResponseEntity<?> save(VehicleLogDto vehicleLog) {
        vehicleLogRepository.save(vehicleLogMapper.ToEntityVehicleLog(vehicleLog));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<?> exitTime(VehicleLogDto vehicleLog) {
        VehicleLog vehicleLog1 = vehicleLogRepository.findById(vehicleLog.getId()).orElseThrow(() -> new RuntimeException("vehicle not found"));
        if (vehicleLog1.getId() == null || vehicleLog.getExit_time().isAfter(vehicleLog1.getEntry_time())) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        vehicleLog1.setExit_time(vehicleLog.getExit_time());
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
