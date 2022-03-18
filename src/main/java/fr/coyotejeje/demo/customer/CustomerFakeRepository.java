package fr.coyotejeje.demo.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "fake")
public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "John Doe", "password123", "email@gmail.com"),
                new Customer(2L, "Maria Doe", "123password", "email@gmail.com")

        );
    }
}
