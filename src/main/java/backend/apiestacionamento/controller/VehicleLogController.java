package backend.apiestacionamento.controller;


import backend.apiestacionamento.dto.VehicleLogRecord;
import backend.apiestacionamento.exception.ParkingFullException;
import backend.apiestacionamento.service.VehicleLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
public class VehicleLogController {

    private final VehicleLogService vehicleLogService;


    public VehicleLogController(VehicleLogService vehicleLogService) {
        this.vehicleLogService = vehicleLogService;
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody VehicleLogRecord vehicleLog) {
        try {
            return vehicleLogService.save(vehicleLog);

        } catch (ParkingFullException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody VehicleLogRecord vehicleLog, @PathVariable Long id) {
        return vehicleLogService.exitTime(vehicleLog, id);
    }

}
