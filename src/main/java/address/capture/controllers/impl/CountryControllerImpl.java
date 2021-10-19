package address.capture.controllers.impl;

import address.capture.controllers.CountryControllerInterface;
import address.capture.models.Country;
import address.capture.models.ResponseDTO;
import address.capture.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryControllerImpl implements CountryControllerInterface {

    protected final CountryService countryService;

    public CountryControllerImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public ResponseEntity<ResponseDTO<List<Country>>> listCountries(String sort) {

        var countryList = countryService.listCountries(sort);
        var responseBody = new ResponseDTO<>(null, countryList);
        return ResponseEntity.ok(responseBody);
    }
}
