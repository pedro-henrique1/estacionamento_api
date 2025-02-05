package backend.apiestacionamento.service;


import backend.apiestacionamento.dto.AddresseDto;
import backend.apiestacionamento.dto.mapper.AddresseMappper;
import backend.apiestacionamento.dto.mapper.EstablishmentMapper;
import backend.apiestacionamento.model.Addresses;
import backend.apiestacionamento.repository.AddressesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    private final AddressesRepository addressesRepository;
    private final AddresseMappper addresseMappper;


    public AddressService(AddressesRepository addressesRepository, AddresseMappper addresseMappper) {
        this.addressesRepository = addressesRepository;
        this.addresseMappper = addresseMappper;
    }

    public AddresseDto createAddress(AddresseDto addresseDto) {
        Addresses address = addresseMappper.ToEntityAddresses(addresseDto);
        addressesRepository.save(address);
        return addresseMappper.AddressesToDto(address);
    }

    public AddresseDto updateAddress(AddresseDto addresseDto) {
        Addresses address = addressesRepository.findById(addresseDto.getId()).orElseThrow(() -> new RuntimeException("address not found"));
        address.setNumber(addresseDto.getNumber());
        address.setComplement(addresseDto.getComplement());
        address.setStreet(addresseDto.getStreet());
        address.setNeighborhood(addresseDto.getNeighborhood());
        address.setCity(addresseDto.getCity());
        address.setState(addresseDto.getState());
        address.setPostal_code(addresseDto.getPostal_code());
        address.setCountry(addresseDto.getCountry());
        addressesRepository.save(address);
        return addresseMappper.AddressesToDto(address);
    }

    public AddresseDto getAddressById(Long id) {
        Addresses address = addressesRepository.findById(id).orElseThrow(() -> new RuntimeException("address not found"));
        return addresseMappper.AddressesToDto(address);
    }

    public List<AddresseDto> getAllAddresses() {
        List<Addresses> addresses = addressesRepository.findAll();
        return addresses.stream().map(addresseMappper::AddressesToDto).collect(Collectors.toList());
    }

    public void deleteAddressById(Long id) {
        addressesRepository.deleteById(id);
    }
}
