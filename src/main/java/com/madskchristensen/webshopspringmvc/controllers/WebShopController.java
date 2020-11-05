package com.madskchristensen.webshopspringmvc.controllers;

import com.madskchristensen.webshopspringmvc.models.Category;
import com.madskchristensen.webshopspringmvc.models.Company;
import com.madskchristensen.webshopspringmvc.models.Product;
import com.madskchristensen.webshopspringmvc.repositories.CategoryRepository;
import com.madskchristensen.webshopspringmvc.repositories.CompanyRepository;
import com.madskchristensen.webshopspringmvc.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebShopController {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    CompanyRepository companyRepository;

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
        Product product = productRepository.findById(id).get();

        model.addAttribute("product", product);
        return "/product/detail";
    }

    @GetMapping("/temp")
    public String temp() {

        return "temp";
    }

    @GetMapping("/products")
    public String productOverview(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    // create product method
    @GetMapping("/product/create")
    public String createProductShow(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("companies", companyRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
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
        model.addAttribute("product", productRepository.findById(id).get());

        return "/product/edit";
    }

    @PostMapping("/product/editDo")
    public String productEdit(@RequestParam long id, @ModelAttribute Product product) {
        productRepository.save(product);

        return "redirect:/products";
    }

    // delete product method
    @GetMapping("/product/delete")
    public String delete(@RequestParam long id, Model model){
        Product product = productRepository.findById(id).get();
        model.addAttribute("product", product);
        return "/product/delete";
    }

    @PostMapping("/product/deleteDo")
    public String deleteDo(@ModelAttribute Product product){
        productRepository.delete(product);
        return "redirect:/products";
    }

    @PostMapping("/product/deleteNo")
    public String deleteNo(@ModelAttribute Product product){

        return "redirect:/products";
    }
}