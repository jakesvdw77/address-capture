package address.capture.controllers.impl;

import address.capture.controllers.AddressControllerInterface;
import address.capture.models.Address;
import address.capture.models.CustomerAddress;
import address.capture.models.ResponseDTO;
import address.capture.services.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AddressControllerImpl implements AddressControllerInterface {

    public final AddressService addressService;

    public AddressControllerImpl(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public ResponseEntity<ResponseDTO<CustomerAddress>> createAddress(Address request) {
        // Http Errors are handled in the the GlobalException Handler
        var response = addressService.createAddress(request);
        var responseBody = new ResponseDTO<>(null, response);
        return ResponseEntity.ok(responseBody);
    }

    @Override
    public ResponseEntity<ResponseDTO<CustomerAddress>> updateAddress(Address request, Integer addressId) {
        var response = addressService.updateAddress(request, addressId);
        var responseBody = new ResponseDTO<>(null, response);
        return ResponseEntity.ok(responseBody);
    }


    @Override
    public ResponseEntity<ResponseDTO<CustomerAddress>> findAddress(Integer addressId) {
        // Http Errors are handled in the the GlobalException Handler
        var response = addressService.findAddress(addressId);
        var responseBody = new ResponseDTO<>(null, response);
        return ResponseEntity.ok(responseBody);
    }

    @Override
    public ResponseEntity<ResponseDTO<List<CustomerAddress>>> listCustomerAddresses() {
        // Http Errors are handled in the the GlobalException Handler
        var response = addressService.listAddresses();
        var responseBody = new ResponseDTO<>(null, response);
        return ResponseEntity.ok(responseBody);

    }

    @Override
    public ResponseEntity<ResponseDTO<Integer>> deleteCustomerAddress(Integer addressId) {
        addressService.deleteAddress(addressId);
        var responseBody = new ResponseDTO<>(null, addressId);
        return ResponseEntity.ok(responseBody);
    }

}
