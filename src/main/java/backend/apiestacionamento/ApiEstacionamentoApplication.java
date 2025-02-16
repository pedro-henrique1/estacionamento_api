package backend.apiestacionamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiEstacionamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiEstacionamentoApplication.class, args);
    }

}
