package address.capture.services.impl;

import address.capture.models.Province;
import address.capture.repositories.ProvinceRepository;
import address.capture.services.ProvinceService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProvinceServiceImpl implements ProvinceService {
    protected final ProvinceRepository provinceRepository;

    protected final ModelMapper modelMapper;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository, ModelMapper modelMapper) {
        this.provinceRepository = provinceRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * List of all available countries
     *
     * @param sort default value "asc" for ascending , desc for descending sort
     * @return
     */
    public List<Province> listProvincesByCountry(String countryCode) {
        var provinces = provinceRepository.findAllByCountryCode(countryCode);

        log.info(String.format("%s Provinces found for country code %s", provinces.size(), countryCode));

        return provinces
                .stream()
                .map(x -> modelMapper.map(x, Province.class))
                .collect(Collectors.toList());
    }


}
