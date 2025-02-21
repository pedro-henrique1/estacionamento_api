package backend.apiestacionamento.controller;


import backend.apiestacionamento.dto.VehicleRecord;
import backend.apiestacionamento.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity<Map<String, String>> put(@RequestBody VehicleRecord vehicle) {
        vehicleService.updateVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message:", "Veiculo atualizado com successo"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message:", "Veiculo deletado com successo"));

    }
}
