package pe.edu.i202224141.cl1_jpa_data_yucra_jhelson.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "Code", length = 3)
    private String code;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Continent", nullable = false, length = 50)
    private String continent;

    @Column(name = "Region", nullable = false, length = 50)
    private String region;

    @Column(name = "SurfaceArea", nullable = false)
    private Double surfaceArea;

    @Column(name = "IndepYear")
    private Integer indepYear;

    @Column(name = "Population", nullable = false)
    private Integer population;

    @Column(name = "LifeExpectancy")
    private Double lifeExpectancy;

    @Column(name = "GNP")
    private Double gnp;

    @Column(name = "GNPOld")
    private Double gnpOld;

    @Column(name = "LocalName", nullable = false, length = 50)
    private String localName;

    @Column(name = "GovernmentForm", nullable = false, length = 50)
    private String governmentForm;

    @Column(name = "HeadOfState", length = 50)
    private String headOfState;

    @Column(name = "Capital")
    private Integer capital;

    @Column(name = "Code2", nullable = false, length = 2)
    private String code2;

    // Relación con City
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;

    // Relación con CountryLanguage
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true,  fetch = FetchType.EAGER)
    private List<CountryLanguage> countryLanguages =new ArrayList<>();
}