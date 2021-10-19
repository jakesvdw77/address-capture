package address.capture.repositories;

import address.capture.entities.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, String> {

    List<ProvinceEntity> findFirstByCountryCodeAndProvinceCode(String country , String province);

    List<ProvinceEntity> findAllByCountryCode(String countryCode);
}

