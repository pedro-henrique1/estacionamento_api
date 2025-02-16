package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.EstablishmentDto;
import backend.apiestacionamento.model.Establishment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface EstablishmentMapper {

    @Mapping(source = "created_at", target = "created_at")
    @Mapping(source = "updated_at", target = "updated_at")
    EstablishmentDto establishmentToDTO(Establishment establishment);

    @Mapping(source = "created_at", target = "created_at")
    @Mapping(source = "updated_at", target = "updated_at")
    Establishment ToEntityEstablishment(EstablishmentDto establishmentDto);

}
