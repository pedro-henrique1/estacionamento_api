package backend.apiestacionamento.controller;


import backend.apiestacionamento.dto.EstablishmentRecord;
import backend.apiestacionamento.service.EstablishmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity<Map<String, String>> updateEstablishment(@RequestBody EstablishmentRecord establishment) {
        establishmentService.updateEstablishment(establishment);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message:", "Estabelecimento atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteEstablishment(@PathVariable Long id) {
        establishmentService.deleteEstablishmentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message:", "Estabelecimento deletado com successo"));
    }

}
