package address.capture.controllers.impl;

import address.capture.controllers.ProvinceControllerInterface;
import address.capture.models.Province;
import address.capture.models.ResponseDTO;
import address.capture.services.ProvinceService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProvinceControllerImpl implements ProvinceControllerInterface {

    protected final ProvinceService provinceService;

    protected final ModelMapper modelMapper;

    public ProvinceControllerImpl(ProvinceService provinceService, ModelMapper modelMapper) {
        this.provinceService = provinceService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<ResponseDTO<List<Province>>> listProvinces(String countryCode) {
        var provinces = provinceService.listProvincesByCountry(countryCode);
        var responseBody = new ResponseDTO<>(null, provinces);
        return ResponseEntity.ok(responseBody);
    }


}
