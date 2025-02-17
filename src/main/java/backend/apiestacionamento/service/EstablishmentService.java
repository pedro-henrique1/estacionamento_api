package backend.apiestacionamento.service;


import backend.apiestacionamento.dto.EstablishmentRecord;
import backend.apiestacionamento.dto.mapper.EstablishmentMapper;
import backend.apiestacionamento.model.Establishment;
import backend.apiestacionamento.repository.EstablishmentRepository;
import backend.apiestacionamento.repository.VehicleLogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstablishmentService {
    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentMapper establishmentMapper;
    private final VehicleLogRepository vehicleLogRepository;


    public EstablishmentService(EstablishmentRepository establishmentRepository, EstablishmentMapper establishmentMapper, VehicleLogRepository vehicleLogRepository) {
        this.establishmentRepository = establishmentRepository;
        this.establishmentMapper = establishmentMapper;
        this.vehicleLogRepository = vehicleLogRepository;
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

    public EstablishmentRecord getEstablishmentById(Long id) {
        Establishment establishment = establishmentRepository.findById(id).orElseThrow(() -> new RuntimeException("establishment not found"));
        return establishmentMapper.establishmentToDTO(establishment);
    }


    public void updateEstablishment(EstablishmentRecord establishmentRecord) {
        Establishment establishment1 = establishmentRepository.findById(establishmentRecord.id()).orElseThrow(() -> new RuntimeException("establishment not found"));
        establishmentMapper.updateEstablishment(establishmentRecord, establishment1);
        establishmentRepository.save(establishment1);
        establishmentMapper.establishmentToDTO(establishment1);

    }

    public void deleteEstablishmentById(Long id) {
        establishmentRepository.deleteById(id);
    }

    public boolean isCarParkingFull(Long establishmentId) {
        Establishment establishment = establishmentRepository.findById(establishmentId).orElse(null);
        int activeCars = vehicleLogRepository.countActiveVehiclesByType(establishmentId, "Carro");
        assert establishment != null;
        return activeCars >= establishment.getVacancies_car();
    }

    public boolean isMotorcycleParkingFull(Long establishmentId) {
        Establishment establishment = establishmentRepository.findById(establishmentId)
                .orElseThrow(() -> new RuntimeException("Establishment not found"));
        int activeMotorcycles = vehicleLogRepository.countActiveVehiclesByType(establishmentId, "Moto");
        return activeMotorcycles >= establishment.getVacancies_motorcycles();
    }
}

