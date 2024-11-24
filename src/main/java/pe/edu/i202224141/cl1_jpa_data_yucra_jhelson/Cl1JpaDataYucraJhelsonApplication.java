package pe.edu.i202224141.cl1_jpa_data_yucra_jhelson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202224141.cl1_jpa_data_yucra_jhelson.repository.CountryRepository;

import java.util.Arrays;

@SpringBootApplication
public class Cl1JpaDataYucraJhelsonApplication implements CommandLineRunner {


	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataYucraJhelsonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Primera consulta
		countryRepository.findById("ARG").ifPresentOrElse(country -> {
			System.out.println("Lenguajes de Argentina (ARG):");
			country.getCountryLanguages().forEach(language -> System.out.println(language.getLanguage()));
		}, () -> {

			countryRepository.findById("PER").ifPresent(country -> {
				System.out.println("Lenguajes de Perú (PER):");
			country.getCountryLanguages().forEach(language -> System.out.println(language.getLanguage()));
			});
		});


		// Eliminar "COL" y "ARG" con eliminación en cascada
		System.out.println("Eliminando los países COL y ARG...");
		countryRepository.deleteAllById(Arrays.asList("COL", "ARG"));
		System.out.println("Países eliminados.");


        //Volver  a ejecutar la consulta inicial
		System.out.println("Repitiendo la consulta después de eliminar ARG:");
		countryRepository.findById("ARG").ifPresentOrElse(country -> {
			System.out.println("Lenguajes de Argentina (ARG):");
			country.getCountryLanguages().forEach(language -> System.out.println(language.getLanguage()));
		}, () -> {
			countryRepository.findById("PER").ifPresent(country -> {
				System.out.println("Lenguajes de Perú (PER):");
				country.getCountryLanguages().forEach(language -> System.out.println(language.getLanguage()));
			});
		});
	}
}



