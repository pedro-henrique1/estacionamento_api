package backend.apiestacionamento.controller;


import backend.apiestacionamento.dto.AddresseRecord;
import backend.apiestacionamento.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddresseRecord> saveAddress(@RequestBody AddresseRecord addressDto) {
        return ResponseEntity.ok(addressService.createAddress(addressDto));
    }

    @PutMapping
    public ResponseEntity<?> updateAddress(@RequestBody AddresseRecord addressDto) {
        return ResponseEntity.ok(addressService.updateAddress(addressDto));
    }

    @GetMapping
    public ResponseEntity<List<AddresseRecord>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddresseRecord> getAddressById(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.noContent().build();
    }

}
