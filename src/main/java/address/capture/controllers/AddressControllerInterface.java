package address.capture.controllers;

import address.capture.models.Address;
import address.capture.models.CustomerAddress;
import address.capture.models.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Managing Customer Address Api Controller")
@RequestMapping(path = "/address", produces = "application/json")
public interface AddressControllerInterface {

    @Operation(description = "Create New Address")
    @PostMapping
    ResponseEntity<ResponseDTO<CustomerAddress>> createAddress(@RequestBody Address request);

    @Operation(description = "Create New Address")
    @PutMapping("/{addressId}")
    ResponseEntity<ResponseDTO<CustomerAddress>> updateAddress(@RequestBody Address request, @PathVariable Integer addressId);

    @Operation(description = "Find address")
    @GetMapping("{addressId}")
    ResponseEntity<ResponseDTO<CustomerAddress>> findAddress(@PathVariable Integer addressId);

    @Operation(description = "List all customer addresses")
    @GetMapping("")
    ResponseEntity<ResponseDTO<List<CustomerAddress>>> listCustomerAddresses();

}
