package backend.apiestacionamento.service;


import backend.apiestacionamento.dto.EstablishmentRecord;
import backend.apiestacionamento.dto.mapper.EstablishmentMapper;
import backend.apiestacionamento.model.Establishment;
import backend.apiestacionamento.repository.EstablishmentRepository;
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

    public EstablishmentRecord creatEstablishment(EstablishmentRecord establishment) {
        if (establishment != null) {

            Establishment establishmentDto = establishmentRepository.save(establishmentMapper.ToEntityEstablishment(establishment));
            return establishmentMapper.establishmentToDTO(establishmentDto);
        }
        ResponseEntity.badRequest().build();
        return null;
    }

    public List<EstablishmentRecord> getAllEstablishments() {
        List<Establishment> establishments = establishmentRepository.findAll();
        return establishments.stream().map(establishmentMapper::establishmentToDTO).collect(Collectors.toList());
    }

    public EstablishmentRecord getEstablishmentById(Integer id) {
        Establishment establishment = establishmentRepository.findById(id).orElseThrow(() -> new RuntimeException("establishment not found"));
        return establishmentMapper.establishmentToDTO(establishment);
    }


    public EstablishmentRecord updateEstablishment(EstablishmentRecord establishmentRecord) {
        Establishment establishment1 = establishmentRepository.findById(Math.toIntExact(establishmentRecord.id())).orElseThrow(() -> new RuntimeException("establishment not found"));
        establishmentMapper.updateEstablishment(establishmentRecord, establishment1);
        establishmentRepository.save(establishment1);
        return establishmentMapper.establishmentToDTO(establishment1);
//        establishment.setName(establishment.getName());
//        establishment.setCnpj(establishment.getCnpj());
//        establishment.setPhone(establishment.getPhone());
//        establishment.setVacancies_motorcycles(establishment.getVacancies_motorcycles());
//        establishment.setVacancies_car(establishment.getVacancies_car());
    }

    public void deleteEstablishmentById(Integer id) {
        establishmentRepository.deleteById(id);
    }
}
