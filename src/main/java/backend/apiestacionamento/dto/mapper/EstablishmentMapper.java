package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.EstablishmentDto;
import backend.apiestacionamento.model.Establishment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EstablishmentMapper {
    EstablishmentMapper INSTANCE = Mappers.getMapper(EstablishmentMapper.class);


    EstablishmentDto establishmentToDTO(Establishment establishment);

    Establishment ToEntityEstablishment(EstablishmentDto establishmentDto);

}
