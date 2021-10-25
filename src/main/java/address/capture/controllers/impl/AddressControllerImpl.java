package address.capture.controllers.impl;

import address.capture.controllers.AddressControllerInterface;
import address.capture.models.Address;
import address.capture.models.CustomerAddress;
import address.capture.models.ResponseDTO;
import address.capture.services.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@Slf4j
public class AddressControllerImpl implements AddressControllerInterface {

    public final AddressService addressService;

    public AddressControllerImpl(AddressService addressService) {
        this.addressService = addressService;
    }

    /**
     * Create a new Address
     *
     * @param request
     * @return
     */
    @Override
    public ResponseEntity<ResponseDTO<CustomerAddress>> createAddress(Address request) {
        // Http Errors are handled in the GlobalException Handler
        log.info("createAddress ", request);
        var response = addressService.createAddress(request);
        var responseBody = new ResponseDTO<>(null, response);
        return ResponseEntity.ok(responseBody);
    }

    /**
     * Updates an existing address
     * If address is not found returns 404 with AddressNotFoundException
     *
     * @param request
     * @param addressId
     * @return
     */
    @Override
    public ResponseEntity<ResponseDTO<CustomerAddress>> updateAddress(Address request, Integer addressId) {

        log.info("updateAddress ", request);

        var response = addressService.updateAddress(request, addressId);
        var responseBody = new ResponseDTO<>(null, response);
        return ResponseEntity.ok(responseBody);
    }


    /**
     * Find the address from the addressId
     * If address is not found returns 404 error with Address not found message
     *
     * @param addressId
     * @return
     */
    @Override
    public ResponseEntity<ResponseDTO<CustomerAddress>> findAddress(Integer addressId) {
        // Http Errors are handled in  the GlobalException Handler
        log.info("findAddress ", addressId);


        var response = addressService.findAddress(addressId);
        var responseBody = new ResponseDTO<>(null, response);
        return ResponseEntity.ok(responseBody);
    }

    /**
     * Provides a list of all available addresses
     *
     * @return
     */
    @Override
    public ResponseEntity<ResponseDTO<List<CustomerAddress>>> listCustomerAddresses() {
        // Http Errors are handled in the GlobalException Handler
        log.info("listCustomerAddresses");

        var response = addressService.listAddresses();
        var responseBody = new ResponseDTO<>(null, response);
        return ResponseEntity.ok(responseBody);

    }

    /**
     * Delete  address
     * If address is not found returns 404 error with Address not found message
     *
     * @param addressId
     * @return
     */
    @Override
    public ResponseEntity<ResponseDTO<Integer>> deleteCustomerAddress(Integer addressId) {
        log.info("deleteCustomerAddress");

        addressService.deleteAddress(addressId);
        var responseBody = new ResponseDTO<>(null, addressId);
        return ResponseEntity.ok(responseBody);
    }

}
