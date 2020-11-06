package com.madskchristensen.webshopspringmvc.controllers;

import com.madskchristensen.webshopspringmvc.models.Category;
import com.madskchristensen.webshopspringmvc.models.Company;
import com.madskchristensen.webshopspringmvc.models.Product;
import com.madskchristensen.webshopspringmvc.repositories.CategoryRepository;
import com.madskchristensen.webshopspringmvc.repositories.CompanyRepository;
import com.madskchristensen.webshopspringmvc.repositories.ProductRepository;
import com.madskchristensen.webshopspringmvc.service.CategoryService;
import com.madskchristensen.webshopspringmvc.service.CompanyService;
import com.madskchristensen.webshopspringmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class WebShopController {

    ProductService productService;
    CategoryService categoryService;
    CompanyService companyService;

    public WebShopController(ProductService productService, CategoryService categoryService, CompanyService companyService){
        this.productService = productService;
        this.categoryService = categoryService;
        this.companyService = companyService;
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
    public String getProductByParameter(@RequestParam long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/product/detail";
    }

    @GetMapping("/temp")
    public String temp() {

        return "temp";
    }

    @GetMapping("/products")
    public String productOverview(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("products", list);
        return "products";
    }

    // create product method
    @GetMapping("/product/create")
    public String createProductShow(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("companies", companyService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "/product/create";
    }

    @PostMapping("/product/createDo")
    public String productInput(@ModelAttribute Product product, @ModelAttribute("categories") Category category, @ModelAttribute("companies") Company company) {
        System.out.println(product);
        System.out.println(category);
        System.out.println(company);
        // productRepository.create(product);

        return "redirect:/products";
    }

    @GetMapping("/product/edit")
    public String productEditShow(@RequestParam long id, Model model) {
        model.addAttribute("product", productService.findById(id));

        return "/product/edit";
    }

    @PostMapping("/product/editDo")
    public String productEdit(@RequestParam long id, @ModelAttribute Product product) {
        productService.update(product);

        return "redirect:/products";
    }

    // delete product method
    @GetMapping("/product/delete")
    public String delete(@RequestParam long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/product/delete";
    }

    @PostMapping("/product/deleteDo")
    public String deleteDo(@ModelAttribute Product product){
        productService.delete(product.getId());
        return "redirect:/products";
    }

    @PostMapping("/product/deleteNo")
    public String deleteNo(@ModelAttribute Product product){

        return "redirect:/products";
    }
}