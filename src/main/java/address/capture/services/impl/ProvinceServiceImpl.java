package address.capture.services.impl;

import address.capture.models.Province;
import address.capture.repositories.ProvinceRepository;
import address.capture.services.ProvinceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    protected final ProvinceRepository provinceRepository;

    protected final ModelMapper modelMapper;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository, ModelMapper modelMapper) {
        this.provinceRepository = provinceRepository;
        this.modelMapper = modelMapper;
    }

    public List<Province> listProvincesByCountry(String countryCode) {
        var provinces = provinceRepository.findAllByCountryCode(countryCode);

        return provinces
                .stream()
                .map(x -> modelMapper.map(x, Province.class))
                .collect(Collectors.toList());
    }


}
