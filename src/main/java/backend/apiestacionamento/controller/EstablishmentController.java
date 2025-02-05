package backend.apiestacionamento.controller;


import backend.apiestacionamento.dto.EstablishmentDto;
import backend.apiestacionamento.service.EstablishmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstablishmentController {

    private final EstablishmentService establishmentService;

    public EstablishmentController(EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }




    @PostMapping("/establishments/create")
    public ResponseEntity CreateEstablishment(@RequestBody EstablishmentDto establishment) {
        establishmentService.creatEstablishment(establishment);
        return ResponseEntity.ok().build();
    }


}
