package com.example.lab8_673380278_9_sec1.controller;

import com.example.lab8_673380278_9_sec1.model.Product;
import com.example.lab8_673380278_9_sec1.model.ProductDetail;
import com.example.lab8_673380278_9_sec1.model.Review;
import com.example.lab8_673380278_9_sec1.service.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        Product product = new Product();

        product.setDetail(new ProductDetail());

        ArrayList<Review> reviews = new ArrayList<>();
        reviews.add(new Review());
        product.setReviews(reviews);

        model.addAttribute("product", product);

        return "products/add";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {

        productService.saveProduct(product);

        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model) {

        Product product = productService.getProductById(id);

        if (product == null) {
            return "redirect:/products";
        }

        model.addAttribute("product", product);

        return "products/edit";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(
            @PathVariable Long id,
            @ModelAttribute Product product) {

        product.setId(id);

        productService.saveProduct(product);

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String showDeletePage(
            @PathVariable Long id,
            Model model) {

        Product product = productService.getProductById(id);

        if (product == null) {
            return "redirect:/products";
        }

        model.addAttribute("product", product);

        return "products/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return "redirect:/products";
    }
}