package backend.apiestacionamento.service;


import backend.apiestacionamento.dto.EstablishmentDto;
import backend.apiestacionamento.dto.mapper.EstablishmentMapper;
import backend.apiestacionamento.repository.EstablishmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EstablishmentService {
    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentMapper establishmentMapper;


    public EstablishmentService(EstablishmentRepository establishmentRepository, EstablishmentMapper establishmentMapper) {
        this.establishmentRepository = establishmentRepository;
        this.establishmentMapper = establishmentMapper;
    }

    public void creatEstablishment(EstablishmentDto establishment) {
        if (establishment != null) {

            establishmentRepository.save(establishmentMapper.ToEntityEstablishment(establishment));
            ResponseEntity.ok().build();
        }
        ResponseEntity.badRequest().build();
    }
}
