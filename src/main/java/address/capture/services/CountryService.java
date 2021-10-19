package address.capture.services;

import address.capture.models.Country;
import address.capture.repositories.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    protected final CountryRepository countryRepository;

    protected final ModelMapper modelMapper;

    public CountryService(CountryRepository countryRepository, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    public List<Country> listCountries(String sort) {

        Sort.Direction direction = sort != null && sort.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

        var countryEntities = countryRepository.findAll(Sort.by(direction, "countryCode"));

        return countryEntities.stream().map(x -> modelMapper.map(x, Country.class)).collect(Collectors.toList());

    }


}
