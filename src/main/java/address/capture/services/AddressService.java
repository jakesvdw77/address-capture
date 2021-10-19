package address.capture.services;

import address.capture.models.Address;
import address.capture.models.CustomerAddress;

import java.util.List;

public interface AddressService {
    CustomerAddress updateAddress(Address address, int addressId);

    CustomerAddress createAddress(Address address);

    void deleteAddress(int addressId);

    CustomerAddress findAddress(int addressId);

    List<CustomerAddress> listAddresses();
}
