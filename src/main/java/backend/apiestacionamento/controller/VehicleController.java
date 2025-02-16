package backend.apiestacionamento.controller;


import backend.apiestacionamento.dto.VehicleRecord;
import backend.apiestacionamento.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @PostMapping
    public ResponseEntity<VehicleRecord> post(@RequestBody VehicleRecord vehicle) {
        ;
        return ResponseEntity.ok(vehicleService.saveVehicle(vehicle).getBody());
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(vehicleService.findAllVehicles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.findVehicleById(id));
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody VehicleRecord vehicle) {
        return ResponseEntity.ok(vehicleService.updateVehicle(vehicle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.deleteVehicle(id));
    }
}
