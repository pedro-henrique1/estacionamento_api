package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.EstablishmentRecord;
import backend.apiestacionamento.model.Establishment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EstablishmentMapper {

    EstablishmentRecord establishmentToDTO(Establishment establishment);

    Establishment ToEntityEstablishment(EstablishmentRecord establishmentRecord);

    void updateEstablishment(EstablishmentRecord dto, @MappingTarget Establishment establishment);

}
