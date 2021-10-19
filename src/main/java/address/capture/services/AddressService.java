package address.capture.services;

import address.capture.entities.AddressEntity;
import address.capture.exceptions.AddressNotFoundException;
import address.capture.exceptions.CountryNotFoundException;
import address.capture.exceptions.ProvinceNotFoundException;
import address.capture.models.Address;
import address.capture.models.CustomerAddress;
import address.capture.repositories.AddressRepository;
import address.capture.repositories.CountryRepository;
import address.capture.repositories.ProvinceRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AddressService {

    protected final AddressRepository addressRepository;

    protected final ProvinceRepository provinceRepository;

    protected final CountryRepository countryRepository;

    protected final ModelMapper modelMapper;

    public AddressService(AddressRepository addressRepository, ProvinceRepository provinceRepository, CountryRepository countryRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.provinceRepository = provinceRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    private AddressEntity setAddressInfo(Address address, AddressEntity entity) {
        var country = countryRepository.findById(address.getCountryCode());

        if (country.isEmpty())
            throw new CountryNotFoundException(address.getCountryCode());

        entity.setCountry(country.get());

        var province = provinceRepository.findFirstByCountryCodeAndProvinceCode(address.getCountryCode(), address.getProvinceCode());

        if (province.isEmpty())
            throw new ProvinceNotFoundException(address.getCountryCode(), address.getProvinceCode());

        entity.setProvince(province.get(0));
        entity = addressRepository.save(entity);
        return entity;

    }

    public CustomerAddress updateAddress(Address address, int addressId) {

        if (addressRepository.findById(addressId).isPresent()) {
            var entity = modelMapper.map(address, AddressEntity.class);
            entity.setAddressId(addressId);
            entity = setAddressInfo(address, entity);
            return modelMapper.map(entity, CustomerAddress.class);
        }

        throw new AddressNotFoundException(addressId);
    }


    public CustomerAddress createAddress(Address address) {

        var entity = modelMapper.map(address, AddressEntity.class);
        entity = setAddressInfo(address, entity);
        return modelMapper.map(entity, CustomerAddress.class);

    }

    public void deleteAddress(int addressId) {
        var address = addressRepository.findById(addressId);

        if (address.isEmpty()) {
            throw new AddressNotFoundException(addressId);
        }
        addressRepository.delete(address.get());

    }

    public CustomerAddress findAddress(int addressId) {
        var address = addressRepository.findById(addressId);

        if (address.isPresent()) {
            return modelMapper.map(address.get(), CustomerAddress.class);
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
