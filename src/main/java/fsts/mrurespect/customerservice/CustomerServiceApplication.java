package fsts.mrurespect.customerservice;

import fsts.mrurespect.customerservice.entity.Customer;
import fsts.mrurespect.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

   @Bean
CommandLineRunner start(CustomerRepository customerRepository){
    return args -> {
        customerRepository.save(Customer.builder().name("John Snow").email("email1@gmail.com").build());
        customerRepository.save(Customer.builder().name("Mr LOL").email("email2@gmail.com").build());
        customerRepository.save(Customer.builder().name("Mm Laurain").email("email3@gmail.com").build());
        customerRepository.save(Customer.builder().name("Bruce Wayne").email("email4@gmail.com").build());
        customerRepository.save(Customer.builder().name("Clark Kent").email("email5@gmail.com").build());
        customerRepository.save(Customer.builder().name("Peter Parker").email("email6@gmail.com").build());
        customerRepository.save(Customer.builder().name("Tony Stark").email("email7@gmail.com").build());
        customerRepository.save(Customer.builder().name("Steve Rogers").email("email8@gmail.com").build());
        customerRepository.save(Customer.builder().name("Natasha Romanoff").email("email9@gmail.com").build());
        customerRepository.save(Customer.builder().name("Bruce Banner").email("email10@gmail.com").build());
        customerRepository.save(Customer.builder().name("Thor Odinson").email("email11@gmail.com").build());
        customerRepository.save(Customer.builder().name("Stephen Strange").email("email12@gmail.com").build());
        customerRepository.save(Customer.builder().name("Wanda Maximoff").email("email13@gmail.com").build());
        customerRepository.save(Customer.builder().name("Vision").email("email14@gmail.com").build());
        customerRepository.save(Customer.builder().name("Sam Wilson").email("email15@gmail.com").build());
        customerRepository.findAll().forEach(System.out::println);
    };
}

}
