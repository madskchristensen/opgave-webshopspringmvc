package com.madskchristensen.webshopspringmvc.controllers;

import com.madskchristensen.webshopspringmvc.models.Product;
import com.madskchristensen.webshopspringmvc.repositories.IProductRepository;
import com.madskchristensen.webshopspringmvc.repositories.ProductRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class WebShopController {

    private IProductRepository productRepository;

    public WebShopController() {
        try {
            productRepository = new ProductRepositoryImpl();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/")
    public String index(){
        // Student student = new Student(1,"hejehej","Lotte", 1533, 10, 10,1234567890);
        // studentRepository.update(student);
        // studentRepository.create(new Student(50,"dadadada","rqrqrq", 2010, 10, 10,1234567890));
        return "index";
    }

    //Very simple prototype of GET-request with parameter
    //https://www.baeldung.com/spring-request-param
    //TODO Direct to detailed view of student
    @GetMapping("/product")
    public String getProductByParameter(@RequestParam int id, Model model) {
        Product product = productRepository.read(id);
        model.addAttribute("product", product);
        return "/product/detail";
    }

    @GetMapping("/temp")
    public String temp() {

        return "temp";
    }

    @GetMapping("/products")
    public String productOverview(Model model) {
        model.addAttribute("products", productRepository.readAll());
        return "products";
    }

    // create product method
    @GetMapping("/product/create")
    public String createProductShow(){
        return "/product/create";
    }

    @PostMapping("/product/createDo")
    public String productInput(@ModelAttribute Product product) {
        productRepository.create(product);

        return "redirect:/products";
    }

    @GetMapping("/product/edit")
    public String productEditShow(@RequestParam int id, Model model) {
        model.addAttribute("product", productRepository.read(id));

        return "/product/edit";
    }

    @PostMapping("/product/editDo")
    public String productEdit(@RequestParam int id, @ModelAttribute Product product) {
        productRepository.update(product);

        return "redirect:/products";
    }

    // delete product method
    @GetMapping("/product/delete")
    public String delete(@RequestParam int id, Model model){
        Product product = productRepository.read(id);
        model.addAttribute("product", product);
        return "/product/delete";
    }

    @PostMapping("/product/deleteDo")
    public String deleteDo(@ModelAttribute Product product){
        productRepository.delete(product.getId());
        return "redirect:/products";
    }

    @PostMapping("/product/deleteNo")
    public String deleteNo(@ModelAttribute Product product){

        return "redirect:/products";
    }
}