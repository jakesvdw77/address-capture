package address.capture.controllers;

import address.capture.models.Address;
import address.capture.models.CustomerAddress;
import address.capture.models.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Address REST Api Controller")
@RequestMapping(path = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
public interface AddressControllerInterface {

    @Operation(description = "Create New Address")
    @PostMapping
    ResponseEntity<ResponseDTO<CustomerAddress>> createAddress(@RequestBody Address request);

    @Operation(description = "Update existing Address")
    @PutMapping("/{addressId}")
    ResponseEntity<ResponseDTO<CustomerAddress>> updateAddress(@RequestBody Address request, @PathVariable Integer addressId);

    @Operation(description = "Find existing address")
    @GetMapping("{addressId}")
    ResponseEntity<ResponseDTO<CustomerAddress>> findAddress(@PathVariable Integer addressId);

    @Operation(description = "List all customers addresses")
    @GetMapping("")
    ResponseEntity<ResponseDTO<List<CustomerAddress>>> listCustomerAddresses();

    @Operation(description = "Delete customer addresses")
    @DeleteMapping("/{addressId}")
    ResponseEntity<ResponseDTO<Integer>> deleteCustomerAddress(@PathVariable Integer addressId);

}
