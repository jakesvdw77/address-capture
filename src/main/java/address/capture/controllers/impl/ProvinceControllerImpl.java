package address.capture.controllers.impl;

import address.capture.controllers.ProvinceControllerInterface;
import address.capture.models.Province;
import address.capture.models.ResponseDTO;
import address.capture.services.ProvinceService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@CrossOrigin(maxAge = 3600)
public class ProvinceControllerImpl implements ProvinceControllerInterface {

    protected final ProvinceService provinceService;

    protected final ModelMapper modelMapper;

    public ProvinceControllerImpl(ProvinceService provinceService, ModelMapper modelMapper) {
        this.provinceService = provinceService;
        this.modelMapper = modelMapper;
    }

    /**
     * Returns list of provinces for a provided countryCode
     * Return Http 404 if country code is not found with CountryNotFoundException message
     * @param countryCode
     * @return
     */
    @Override
    public ResponseEntity<ResponseDTO<List<Province>>> listProvinces(String countryCode) {
        var provinces = provinceService.listProvincesByCountry(countryCode);
        var responseBody = new ResponseDTO<>(null, provinces);
        return ResponseEntity.ok(responseBody);
    }


}
