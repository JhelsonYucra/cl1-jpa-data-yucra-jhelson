package pe.edu.i202224141.cl1_jpa_data_yucra_jhelson.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202224141.cl1_jpa_data_yucra_jhelson.entity.Country;

public interface CountryRepository           extends CrudRepository<Country, String> {
}
