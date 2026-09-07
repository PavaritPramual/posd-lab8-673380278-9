package com.example.lab8_673380278_9_sec1.service;

import com.example.lab8_673380278_9_sec1.model.Product;
import com.example.lab8_673380278_9_sec1.model.Review;
import com.example.lab8_673380278_9_sec1.repository.ProductRepository;
import com.example.lab8_673380278_9_sec1.strategy.*;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
    List<Product> products = productRepository.findAll();

    for (Product product : products) {
        product.setDiscountedPrice(calculateDiscountedPrice(product));
    }

    return products;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {

        if (product.getDetail() != null) {
            product.getDetail().setProduct(product);
        }

        if (product.getReviews() != null) {
            for (Review review : product.getReviews()) {
                review.setProduct(product);

                if (review.getReviewDate() == null) {
                    review.setReviewDate(LocalDate.now());
                }
            }
        }

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public double calculateDiscountedPrice(Product product) {

        DiscountContext context = new DiscountContext();

        if ("MEMBER".equalsIgnoreCase(product.getDiscountType())) {
            context.setStrategy(new MemberDiscountStrategy());

        } else if ("SEASONAL".equalsIgnoreCase(product.getDiscountType())) {
            context.setStrategy(new SeasonalSaleStrategy());

        } else {
            context.setStrategy(new NoDiscountStrategy());
        }

        return context.executeStrategy(product.getPrice());
    }
}