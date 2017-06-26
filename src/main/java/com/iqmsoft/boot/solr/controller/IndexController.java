package com.iqmsoft.boot.solr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iqmsoft.boot.solr.model.Product;
import com.iqmsoft.boot.solr.repos.ProductRepository;


@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private ProductRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody String create() {

        this.repository.deleteAll();

        // insert some products
        this.repository.save(new Product("1", "Android"));
        this.repository.save(new Product("2", "IOS"));
        this.repository.save(new Product("3", "Windows"));

        // fetch all
        System.out.println("Products found by findAll():");
        System.out.println("----------------------------");
        for (Product product : this.repository.findAll()) {
            System.out.println(product);
        }
        System.out.println();

        // fetch a single product
        System.out.println("Products found with findByNameStartingWith('And'):");
        System.out.println("--------------------------------");
        for (Product product : this.repository.findByNameStartingWith("And")) {
            System.out.println(product);
        }
        System.out.println();
        return "OK";
    }
}
