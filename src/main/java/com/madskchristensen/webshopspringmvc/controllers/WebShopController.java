package com.madskchristensen.webshopspringmvc.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.madskchristensen.webshopspringmvc.models.Category;
import com.madskchristensen.webshopspringmvc.models.Company;
import com.madskchristensen.webshopspringmvc.models.Product;
import com.madskchristensen.webshopspringmvc.repositories.*;
import com.madskchristensen.webshopspringmvc.util.RepositoryManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class WebShopController {

    private IProductRepository productRepository;
    private ICompanyRepository companyRepository;
    private ICategoryRepository categoryRepository;

    public WebShopController() {
        try {
            productRepository = RepositoryManager.getInstance().getProductRepository();
            companyRepository = RepositoryManager.getInstance().getCompanyRepository();
            categoryRepository = RepositoryManager.getInstance().getCategoryRepository();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    //Very simple prototype of GET-request with parameter
    //https://www.baeldung.com/spring-request-param
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
    public String createProductShow(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("companies", companyRepository.readAll());
        model.addAttribute("categories", categoryRepository.readAll());
        return "/product/create";
    }

    @PostMapping("/product/createDo")
    public String productInput(@ModelAttribute Product product) {
        System.out.println(product);
        productRepository.create(product);

        return "redirect:/products";
    }

    @GetMapping("/product/edit")
    public String productEditShow(@RequestParam int id, Model model) {
        model.addAttribute("product", productRepository.read(id));

        return "/product/edit";
    }

    @PostMapping("/product/editDo")
    public String productEdit(@ModelAttribute Product product) {
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