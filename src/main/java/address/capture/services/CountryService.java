package address.capture.services;

import address.capture.models.Country;

import java.util.List;

public interface CountryService
{
    List<Country> listCountries(String sort);
}
