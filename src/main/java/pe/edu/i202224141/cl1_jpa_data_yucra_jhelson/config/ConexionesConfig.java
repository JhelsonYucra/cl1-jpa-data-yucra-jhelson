package pe.edu.i202224141.cl1_jpa_data_yucra_jhelson.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConexionesConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();

        // Configuración del pool de conexiones
        hikariConfig.setMaximumPoolSize(30);
        hikariConfig.setMinimumIdle(4);
        hikariConfig.setIdleTimeout(4 * 60 * 1000L); // 4 minutos
        hikariConfig.setConnectionTimeout(45 * 1000L); // 45 segundos

        // Configuración de la base de datos desde variables de entorno
        hikariConfig.setJdbcUrl(System.getenv("jdbc:mysql://localhost:3306/world"));
        hikariConfig.setUsername(System.getenv("root"));
        hikariConfig.setPassword(System.getenv("123456"));
        hikariConfig.setDriverClassName(System.getenv("com.mysql.cj.jdbc.Driver"));

        return new HikariDataSource(hikariConfig);
    }
}
