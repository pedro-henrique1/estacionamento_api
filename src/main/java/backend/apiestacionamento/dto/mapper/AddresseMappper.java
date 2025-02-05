package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.AddresseDto;
import backend.apiestacionamento.dto.EstablishmentDto;
import backend.apiestacionamento.model.Addresses;
import backend.apiestacionamento.model.Establishment;
import jakarta.persistence.MappedSuperclass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddresseMappper {
    AddresseMappper INSTANCE = Mappers.getMapper(AddresseMappper.class);

    @Mapping(source = "establishment.id", target = "establishmentId")
    AddresseDto AddressesToDto(Addresses addresse);

    @Mapping(source = "establishmentId", target = "establishment.id")
    Addresses ToEntityAddresses(AddresseDto addresseDto);


}
