package address.capture.services;

import address.capture.entities.AddressEntity;
import address.capture.exceptions.AddressNotFoundException;
import address.capture.models.Address;
import address.capture.models.CustomerAddress;
import address.capture.repositories.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AddressService {

    protected final AddressRepository addressRepository;

    protected final ModelMapper modelMapper;

    public AddressService(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    public CustomerAddress updateAddress(Address address, int addressId) {

//        var address = addressRepository.findById(addressId);
//
//        if (address.isPresent()) {
//            return modelMapper.map(address, CustomerAddress.class);
//        }

        throw new AddressNotFoundException(addressId);
    }

    public CustomerAddress createAddress(Address address) {
        var entity = modelMapper.map(address, AddressEntity.class);
        entity = addressRepository.save(entity);
        return modelMapper.map(entity, CustomerAddress.class);
    }

    public CustomerAddress findAddress(int addressId) {
        var address = addressRepository.findById(addressId);

        if (address.isPresent()) {
            return modelMapper.map(address, CustomerAddress.class);
        }

        throw new AddressNotFoundException(addressId);
    }

    public List<CustomerAddress> listAddresses() {
        var addressStream = addressRepository.findAll();

        var addressList = addressStream
                .stream()
                .map(x -> modelMapper.map(x, CustomerAddress.class))
                .collect(Collectors.toList());

        return addressList;
    }

}
