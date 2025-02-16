package backend.apiestacionamento.controller;


import backend.apiestacionamento.dto.EstablishmentRecord;
import backend.apiestacionamento.service.EstablishmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/establishments")
public class EstablishmentController {

    private final EstablishmentService establishmentService;

    public EstablishmentController(EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }

    @PostMapping
    public ResponseEntity<EstablishmentRecord> CreateEstablishment(@RequestBody EstablishmentRecord establishment) {
        return ResponseEntity.ok(establishmentService.creatEstablishment(establishment));
    }

    @GetMapping
    public ResponseEntity<?> getAllEstablishments() {
        return ResponseEntity.ok(establishmentService.getAllEstablishments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEstablishmentById(@PathVariable Long id) {
        return ResponseEntity.ok(establishmentService.getEstablishmentById(id));
    }

    @PatchMapping
    public ResponseEntity<EstablishmentRecord> updateEstablishment(@RequestBody EstablishmentRecord establishment) {
        return ResponseEntity.ok(establishmentService.updateEstablishment(establishment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEstablishment(@PathVariable Long id) {
        establishmentService.deleteEstablishmentById(id);
        return ResponseEntity.ok().build();
    }

}
