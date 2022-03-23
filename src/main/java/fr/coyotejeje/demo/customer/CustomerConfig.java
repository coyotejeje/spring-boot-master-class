package fr.coyotejeje.demo.customer;

import fr.coyotejeje.demo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp) {
        return args -> {
            System.out.println("Command Line runner");
            System.out.println(infoApp);
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return new  CustomerFakeRepository();
    }
}
