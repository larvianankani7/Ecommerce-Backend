package com.syssian.ecommerce.config;

import com.syssian.ecommerce.model.Product;
import com.syssian.ecommerce.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Enable CORS for our React Frontend
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }

    // Insert sample items into the database at startup
    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            repository.save(new Product(null, "Wireless Headphones", "High-quality sound with noise cancellation.", 99.99, "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500", "Electronics"));
            repository.save(new Product(null, "Classic Leather Watch", "Elegant minimalist watch with a genuine leather band.", 149.50, "https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=500", "Accessories"));
            repository.save(new Product(null, "Running Shoes", "Lightweight and breathable athletic sports sneakers.", 79.99, "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=500", "Clothing"));
            repository.save(new Product(null, "Ergonomic Office Chair", "Comfortable lumbar support chair for long work hours.", 199.99, "https://images.unsplash.com/photo-1505797149-43b0069ec26b?w=500", "Furniture"));
        };
    }
}