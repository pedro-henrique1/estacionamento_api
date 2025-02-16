package backend.apiestacionamento.service;


import backend.apiestacionamento.dto.AddresseRecord;
import backend.apiestacionamento.dto.mapper.AddresseMappper;
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

    public AddresseRecord createAddress(AddresseRecord addresseRecord) {
        Addresses address = addresseMappper.ToEntityAddresses(addresseRecord);
        addressesRepository.save(address);
        return addresseMappper.AddressesToDto(address);
    }

    public AddresseRecord updateAddress(AddresseRecord addresseRecord) {
        Addresses address = addressesRepository.findById(addresseRecord.id()).orElseThrow(() -> new RuntimeException("error"));
        addresseMappper.updateAddressesFromDto(addresseRecord, address);
        addressesRepository.save(address);
        return addresseMappper.AddressesToDto(address);
//        Addresses address = addressesRepository.findById(addresseRecord.id()).orElseThrow(() -> new RuntimeException("address not found"));
//        address.setNumber(addresseRecord.number());
//        address.setComplement(addresseRecord.complement());
//        address.setStreet(addresseRecord.street());
//        address.setNeighborhood(addresseRecord.neighborhood());
//        address.setCity(addresseRecord.city());
//        address.setState(addresseRecord.state());
//        address.setPostal_code(addresseRecord.postal_code());
//        address.setCountry(addresseRecord.country());
//        addressesRepository.save(address);
//        return addresseMappper.AddressesToDto(address);
    }

    public AddresseRecord getAddressById(Integer id) {
        Addresses address = addressesRepository.findById(id).orElseThrow(() -> new RuntimeException("address not found"));
        return addresseMappper.AddressesToDto(address);
    }

    public List<AddresseRecord> getAllAddresses() {
        List<Addresses> addresses = addressesRepository.findAll();
        return addresses.stream().map(addresseMappper::AddressesToDto).collect(Collectors.toList());
    }

    public void deleteAddressById(Integer id) {
        addressesRepository.deleteById(id);
    }
}
