package address.capture.repositories;

import address.capture.entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String> {

    List<Province> findFirstByCountryCodeAndProvinceCode(String country , String province);

    List<Province> findAllByCountryCode(String countryCode);
}

