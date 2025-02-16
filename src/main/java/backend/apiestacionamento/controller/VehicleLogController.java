package backend.apiestacionamento.controller;


import backend.apiestacionamento.dto.VehicleLogDto;
import backend.apiestacionamento.model.VehicleLog;
import backend.apiestacionamento.service.VehicleLogService;
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
    public ResponseEntity<?> save(@RequestBody VehicleLogDto vehicleLog) {
        return vehicleLogService.save(vehicleLog);

    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody VehicleLogDto vehicleLog) {
        return vehicleLogService.exitTime(vehicleLog);
    }

}
