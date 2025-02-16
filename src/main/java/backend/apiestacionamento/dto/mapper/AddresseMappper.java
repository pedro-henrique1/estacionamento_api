package backend.apiestacionamento.dto.mapper;


import backend.apiestacionamento.dto.AddresseRecord;
import backend.apiestacionamento.model.Addresses;
import backend.apiestacionamento.model.Establishment;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddresseMappper {


    @Mapping(source = "establishment", target = "establishment") // Transforma o objeto em ID
//    @Mapping(source = "createdAt", target = "created_at")
//    @Mapping(source = "updatedAt", target = "updated_at")
    AddresseRecord AddressesToDto(Addresses addresse);

    @Mapping(source = "establishment", target = "establishment")
//    @Mapping(source = "created_at", target = "createdAt")
//    @Mapping(source = "updated_at", target = "updatedAt")
    Addresses ToEntityAddresses(AddresseRecord addresses);

    void updateAddressesFromDto(AddresseRecord dto, @MappingTarget Addresses entity);

    default Long map(Establishment establishment) {
        return establishment != null ? establishment.getId() : null;
    }

    default Establishment map(Long id) {
        if (id == null) {
            return null;
        }
        Establishment establishment = new Establishment();
        establishment.setId(id);
        return establishment;
    }

}
