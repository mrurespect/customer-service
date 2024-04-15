package fsts.mrurespect.inventoryservice;

import fsts.mrurespect.inventoryservice.entity.Product;
import fsts.mrurespect.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
   @Bean
    CommandLineRunner start(ProductRepository productRepository){
    return args -> {
        for (int i = 1; i <= 20; i++) {
            productRepository.save(new Product(null,"Product " + i, i * 10));
        }
        productRepository.findAll().forEach(System.out::println);
    };
    }
}

