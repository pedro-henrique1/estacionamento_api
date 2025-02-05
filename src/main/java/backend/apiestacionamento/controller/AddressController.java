package backend.apiestacionamento.controller;


import backend.apiestacionamento.dto.AddresseDto;
import backend.apiestacionamento.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddresseDto> saveAddress(@RequestBody AddresseDto addressDto) {
        return ResponseEntity.ok(addressService.createAddress(addressDto));
    }

    @PutMapping
    public ResponseEntity<AddresseDto> updateAddress(@RequestBody AddresseDto addressDto) {
        return ResponseEntity.ok(addressService.updateAddress(addressDto));
    }

    @GetMapping
    public ResponseEntity<List<AddresseDto>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddresseDto> getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.noContent().build();
    }

}
