package backend.apiestacionamento.controller;


import backend.apiestacionamento.dto.AddresseRecord;
import backend.apiestacionamento.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> updateAddress(@RequestBody AddresseRecord addressDto) {
        addressService.updateAddress(addressDto);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message:", "Endereço atualizado com successo"));

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
    public ResponseEntity<Map<String, String>> deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message:", "Endereço deletado com sucesso"));
    }

}
