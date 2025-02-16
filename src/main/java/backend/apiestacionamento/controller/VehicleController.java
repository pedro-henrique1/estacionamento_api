package backend.apiestacionamento.controller;


import backend.apiestacionamento.dto.VehicleDto;
import backend.apiestacionamento.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;


    @PostMapping
    public ResponseEntity<VehicleDto> post(@RequestBody VehicleDto vehicle) {
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
    public ResponseEntity<?> put(@RequestBody VehicleDto vehicle) {
        return ResponseEntity.ok(vehicleService.updateVehicle(vehicle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.deleteVehicle(id));
    }
}
