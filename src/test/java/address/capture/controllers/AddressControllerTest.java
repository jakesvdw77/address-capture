package address.capture.controllers;

import address.capture.controllers.impl.AddressControllerImpl;
import address.capture.exceptions.AddressNotFoundException;
import address.capture.models.Address;
import address.capture.models.Country;
import address.capture.models.CustomerAddress;
import address.capture.models.Province;
import address.capture.services.impl.AddressServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AddressControllerTest {


    @InjectMocks
    private AddressControllerImpl addressController;

    @Mock
    private AddressServiceImpl addressService;

    @BeforeEach
    void setup() {

        CustomerAddress mockCustomer = new CustomerAddress();
        mockCustomer.setAddressId(1);
        mockCustomer.setCity("Pretoria");
        mockCustomer.setSuburb("Waterkloof");
        mockCustomer.setLine1("Office Park");
        mockCustomer.setLine2("1 Lynwood road");
        mockCustomer.setCountry(new Country("ZA", "South Africa"));
        mockCustomer.setProvince(new Province("ZA", "GP", "Gauteng"));

        List<CustomerAddress> addressList = new ArrayList<>();
        addressList.add(mockCustomer);

        when(addressService.createAddress(any())).thenReturn(mockCustomer);
        when(addressService.updateAddress(any(), anyInt())).thenReturn(mockCustomer);
        when(addressService.findAddress(1)).thenReturn(mockCustomer);
        when(addressService.findAddress(2)).thenThrow(new AddressNotFoundException(2));
        when(addressService.listAddresses()).thenReturn(addressList);
    }

    @Test
    void testAddressFound() {

        var response = addressController.findAddress(1);
        assertNotNull(response);
        assertNotNull(response.getBody().getData());
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().getData().getAddressId());
    }


    @Test
    void testAddressNotFound() {
        int errorRecord = -1;

        try {
            addressController.findAddress(2);
        } catch (AddressNotFoundException err) {
            errorRecord = err.getAddressId();
        }
        assertEquals(2, errorRecord);
    }

    @Test
    void testCreateAddress()
    {

        var response = addressController.createAddress(new Address());
        assertNotNull(response);
        assertNotNull(response.getBody().getData());
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().getData().getAddressId());
    }


    @Test
    void testUpdateAddress()
    {
        var response = addressController.updateAddress(new Address(),1);
        assertNotNull(response);
        assertNotNull(response.getBody().getData());
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().getData().getAddressId());
    }


    @Test
    void testDeleteAddress()
    {
//        var response = addressController.deleteCustomerAddress(1);
//        assertNotNull(response);
//        assertNotNull(response.getBody().getData());
//        assertEquals(200, response.getStatusCode().value());
//        assertEquals(1, response.getBody().getData().getAddressId());
    }





}
