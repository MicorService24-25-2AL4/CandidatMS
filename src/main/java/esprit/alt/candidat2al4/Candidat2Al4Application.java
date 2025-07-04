package esprit.alt.candidat2al4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Candidat2Al4Application {

    public static void main(String[] args) {
        SpringApplication.run(Candidat2Al4Application.class, args);
    }

}
