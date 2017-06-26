package com.iqmsoft.boot.solr.repos;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.iqmsoft.boot.solr.model.Product;

import java.util.List;


public interface ProductRepository extends SolrCrudRepository<Product, String> {
    List<Product> findByNameStartingWith(String name);
}