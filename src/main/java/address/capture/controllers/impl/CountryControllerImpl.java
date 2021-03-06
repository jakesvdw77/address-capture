package address.capture.controllers.impl;

import address.capture.controllers.CountryControllerInterface;
import address.capture.models.Country;
import address.capture.models.ResponseDTO;
import address.capture.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
public class CountryControllerImpl implements CountryControllerInterface {

    protected final CountryService countryService;

    public CountryControllerImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * Returns sorted list of all countries
     * @param sort
     * @return
     */
    @Override
    public ResponseEntity<ResponseDTO<List<Country>>> listCountries(String sort) {

        var countryList = countryService.listCountries(sort);
        var responseBody = new ResponseDTO<>(null, countryList);
        return ResponseEntity.ok(responseBody);
    }
}
