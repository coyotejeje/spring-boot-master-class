package fr.coyotejeje.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        // given
        Customer jamila = new Customer(
                1L,
                "Jamila",
                "password",
                "jamila@yahoo.fr"
        );
        Customer john = new Customer(
                2L,
                "John",
                "password",
                "john@yahoo.fr"
        );

        customerRepository.saveAll(Arrays.asList(jamila, john));

        // when
        List<Customer> customers = underTest.getCustomers();

        // then
        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        // given
        Customer jamila = new Customer(
                1L,
                "Jamila",
                "password",
                "jamila@yahoo.fr"
        );

        customerRepository.save(jamila);

        // when
        Customer actual = underTest.getCustomer(1L);

        // then
        assertEquals(1L, actual.getId());
        assertEquals("Jamila", actual.getName());
        assertEquals("password", actual.getPassword());
        assertEquals("jamila@yahoo.fr", actual.getEmail());
    }
}