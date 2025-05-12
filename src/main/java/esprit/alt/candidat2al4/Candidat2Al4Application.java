package esprit.alt.candidat2al4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Candidat2Al4Application {

    public static void main(String[] args) {
        SpringApplication.run(Candidat2Al4Application.class, args);
    }

}
