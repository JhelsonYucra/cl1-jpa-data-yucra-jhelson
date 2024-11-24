package pe.edu.i202224141.cl1_jpa_data_yucra_jhelson.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    @Id
    @Column(name = "Language", length = 30, nullable = false)
    private String language; // Clave primaria

    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country; // Clave foránea hacia Country

    @Column(name = "IsOfficial", nullable = false, columnDefinition = "ENUM('T','F')")
    private String isOfficial;

    @Column(name = "Percentage", nullable = false)
    private Double percentage;
}