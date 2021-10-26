package address.capture.services.impl;

import address.capture.entities.AddressEntity;
import address.capture.exceptions.AddressNotFoundException;
import address.capture.exceptions.CountryNotFoundException;
import address.capture.exceptions.ProvinceNotFoundException;
import address.capture.models.Address;
import address.capture.models.CustomerAddress;
import address.capture.repositories.AddressRepository;
import address.capture.repositories.CountryRepository;
import address.capture.repositories.ProvinceRepository;
import address.capture.services.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    private static final String FOUND_ADDRESS = "Found address %s";
    private static final String DELETED_ADDRESS = "Deleted address %s";
    private static final String CREATED_ADDRESS = "Created address %s";
    private static final String UPDATED_ADDRESS = "Updated address %s";

    protected final AddressRepository addressRepository;
    protected final ProvinceRepository provinceRepository;
    protected final CountryRepository countryRepository;
    protected final ModelMapper modelMapper;


    public AddressServiceImpl(AddressRepository addressRepository, ProvinceRepository provinceRepository, CountryRepository countryRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.provinceRepository = provinceRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Set teh address info
     * Throws CountryNotFoundException if country code is not valid
     * Throws ProvinceNotFoundException if the province code is not valid.
     * @param address
     * @param entity
     * @return
     */
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

    /**
     * Update Existing address
     * Throws AddressNotFoundException if address is not found exception
     * @param address
     * @param addressId
     * @return
     */
    public CustomerAddress updateAddress(Address address, int addressId) {

        if (addressRepository.findById(addressId).isPresent()) {

            log.debug(String.format(FOUND_ADDRESS, addressId));
            var entity = modelMapper.map(address, AddressEntity.class);
            entity.setAddressId(addressId);
            entity = setAddressInfo(address, entity);

            log.info(UPDATED_ADDRESS, entity.getAddressId());

            return modelMapper.map(entity, CustomerAddress.class);
        }

        throw new AddressNotFoundException(addressId);
    }


    /**
     * Creates an address
     * @param address
     * @return
     */
    public CustomerAddress createAddress(Address address) {

        var entity = modelMapper.map(address, AddressEntity.class);
        entity = setAddressInfo(address, entity);

        log.info(CREATED_ADDRESS, entity.getAddressId());
        return modelMapper.map(entity, CustomerAddress.class);

    }

    /**
     * Delete an address
     * Throws AddressNotFoundException if addressId is not found
     * @param addressId
     */
    public void deleteAddress(int addressId) {
        var address = addressRepository.findById(addressId);

        if (address.isEmpty()) {
            throw new AddressNotFoundException(addressId);
        }

        log.debug(String.format(FOUND_ADDRESS, addressId));

        addressRepository.delete(address.get());

        log.info(String.format(DELETED_ADDRESS, addressId));

    }

    /**
     * Find an address from provided addressId
     * Throws Address not found exception when not valid addressId
     * @param addressId
     * @return
     */
    public CustomerAddress findAddress(int addressId) {
        var address = addressRepository.findById(addressId);

        if (address.isPresent()) {

            log.info(String.format(FOUND_ADDRESS, addressId));

            return modelMapper.map(address.get(), CustomerAddress.class);
        }

        throw new AddressNotFoundException(addressId);
    }

    /**
     * List all available addresses
     * @return
     */
    public List<CustomerAddress> listAddresses() {
        var addressStream = addressRepository.findAll();

        return addressStream
                .stream()
                .map(x -> modelMapper.map(x, CustomerAddress.class))
                .collect(Collectors.toList());

    }

}
