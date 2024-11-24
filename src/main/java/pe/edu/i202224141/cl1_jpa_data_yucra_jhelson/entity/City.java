package pe.edu.i202224141.cl1_jpa_data_yucra_jhelson.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Name", nullable = false, length = 35)
    private String name;

    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;

    @Column(name = "District", nullable = false, length = 20)
    private String district;

    @Column(name = "Population", nullable = false)
    private Integer population;
}