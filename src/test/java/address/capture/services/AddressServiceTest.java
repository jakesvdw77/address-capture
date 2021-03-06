package address.capture.services;

import address.capture.entities.AddressEntity;
import address.capture.entities.CountryEntity;
import address.capture.entities.ProvinceEntity;
import address.capture.exceptions.CountryNotFoundException;
import address.capture.exceptions.ProvinceNotFoundException;
import address.capture.models.Address;
import address.capture.models.Country;
import address.capture.models.CustomerAddress;
import address.capture.models.Province;
import address.capture.repositories.AddressRepository;
import address.capture.repositories.CountryRepository;
import address.capture.repositories.ProvinceRepository;
import address.capture.services.impl.AddressServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AddressServiceTest {
    @Mock
    private AddressRepository addressRepository;

    @Mock
    private ProvinceRepository provinceRepository;

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    @Mock
    private ModelMapper modelMapper;

    private Address address;

    private CustomerAddress customerAddress;

    private AddressEntity entity;

    @BeforeEach
    void setup() {

        address = new Address();
        address.setCity("Pretoria");
        address.setSuburb("Waterkloof");
        address.setLine1("Office Park");
        address.setLine2("1 Lynwood road");
        address.setCountryCode("ZA");
        address.setProvinceCode("GP");

        customerAddress = new CustomerAddress();
        customerAddress.setAddressId(1);
        customerAddress.setCity("Pretoria");
        customerAddress.setSuburb("Waterkloof");
        customerAddress.setLine1("Office Park");
        customerAddress.setLine2("1 Lynwood road");
        customerAddress.setCountry(new Country("ZA", "South Africa"));
        customerAddress.setProvince(new Province("ZA", "GP", "Gauteng"));


        entity = new AddressEntity();
        entity.setAddressId(1);
        entity.setAddressId(1);
        entity.setCity("Pretoria");
        entity.setSuburb("Waterkloof");
        entity.setLine1("Office Park");
        entity.setLine2("1 Lynwood road");
        entity.setCountry(new CountryEntity("ZA", "South Africa"));
        entity.setProvince(new ProvinceEntity("ZA", "GP", "Gauteng"));

        List<ProvinceEntity> entities = new ArrayList<>();
        entities.add(entity.getProvince());

        when(modelMapper.map(any(Address.class), any())).thenReturn(entity);

        when(modelMapper.map(any(AddressEntity.class), any())).thenReturn(customerAddress);

        when(countryRepository.findById("ZA")).thenReturn(Optional.of(entity.getCountry()));

        when(provinceRepository.findFirstByCountryCodeAndProvinceCode("ZA", "GP")).thenReturn(entities);

        when(addressRepository.findById(1)).thenReturn(Optional.of(entity));

        when(addressRepository.save(any())).thenReturn(entity);

    }

    @Test
    void testNewAddress() {

        var result = addressService.createAddress(address);

        assertNotNull(result);

        assertEquals(1, result.getAddressId());

    }

    @Test
    void testCreateCountryNotFound() {
        Exception error = null;
        try {
            address.setCountryCode(null);
            addressService.createAddress(address);
        } catch (CountryNotFoundException err) {
            error = err;
        }

        assertNotNull(error);

    }

    @Test
    void testCreateProvinceNotFound() {

        Exception error = null;
        try {
            address.setProvinceCode(null);
            addressService.createAddress(address);
        } catch (ProvinceNotFoundException err) {
            error = err;
        }

        assertNotNull(error);

    }


    @Test
    void testUpdateCountryNotFound() {
        Exception error = null;
        try {
            address.setCountryCode(null);
            addressService.updateAddress(address, 1);
        } catch (CountryNotFoundException err) {
            error = err;
        }

        assertNotNull(error);

    }

    @Test
    void testUpdateProvinceNotFound() {

        Exception error = null;
        try {
            address.setProvinceCode(null);
            addressService.updateAddress(address, 1);
        } catch (ProvinceNotFoundException err) {
            error = err;
        }

        assertNotNull(error);

    }


    @Test
    void testUpdateAddress() {

        address.setCity("New City");
        customerAddress.setCity("New City");

        var result = addressService.updateAddress(address, 1);

        assertEquals("New City", result.getCity());

    }


}
