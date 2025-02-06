package backend.apiestacionamento.controller;


import backend.apiestacionamento.dto.VehicleDto;
import backend.apiestacionamento.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody VehicleDto vehicle) {
        vehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        vehicleService.findAllVehicles();
        return ResponseEntity.ok().build();
    }

    @GetMapping("${id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        vehicleService.findVehicleById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody VehicleDto vehicle) {
        vehicleService.updateVehicle(vehicle);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("${id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok().build();
    }
}
