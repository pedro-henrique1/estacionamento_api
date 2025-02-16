package backend.apiestacionamento.service;


import backend.apiestacionamento.dto.EstablishmentDto;
import backend.apiestacionamento.dto.mapper.EstablishmentMapper;
import backend.apiestacionamento.model.Establishment;
import backend.apiestacionamento.repository.EstablishmentRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstablishmentService {
    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentMapper establishmentMapper;


    public EstablishmentService(EstablishmentRepository establishmentRepository, EstablishmentMapper establishmentMapper) {
        this.establishmentRepository = establishmentRepository;
        this.establishmentMapper = establishmentMapper;
    }

    public EstablishmentDto creatEstablishment(EstablishmentDto establishment) {
        if (establishment != null) {

            Establishment establishmentDto = establishmentRepository.save(establishmentMapper.ToEntityEstablishment(establishment));
            return establishmentMapper.establishmentToDTO(establishmentDto);
        }
        ResponseEntity.badRequest().build();
        return null;
    }

    public List<EstablishmentDto> getAllEstablishments() {
        List<Establishment> establishments = establishmentRepository.findAll();
        return establishments.stream().map(establishmentMapper::establishmentToDTO).collect(Collectors.toList());
    }

    public EstablishmentDto getEstablishmentById(Long id) {
        Establishment establishment = establishmentRepository.findById(id).orElseThrow(() -> new RuntimeException("establishment not found"));
        return establishmentMapper.establishmentToDTO(establishment);
    }


    public EstablishmentDto updateEstablishment(EstablishmentDto establishment) {
        Establishment establishment1 = establishmentRepository.findById(establishment.getId()).orElseThrow(() -> new RuntimeException("establishment not found"));
        establishment.setName(establishment1.getName());
        establishment.setCnpj(establishment.getCnpj());
        establishment.setPhone(establishment.getPhone());
        establishment.setVacancies_motorcycles(establishment.getVacancies_motorcycles());
        establishment.setVacancies_car(establishment.getVacancies_car());
        establishmentRepository.save(establishment1);
        return establishmentMapper.establishmentToDTO(establishment1);
    }

    public void deleteEstablishmentById(Long id) {
        establishmentRepository.deleteById(id);
    }
}
