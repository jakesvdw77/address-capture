package address.capture.services;

import address.capture.models.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> listProvincesByCountry(String countryCode);
}
