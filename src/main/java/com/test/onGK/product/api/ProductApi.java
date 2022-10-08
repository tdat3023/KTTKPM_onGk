package com.test.onGK.product.api;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductApi {

	@Autowired
	private ProductRepository pRepo;
	
	
	@GetMapping("/")
	public List<Product> getList(){
		return pRepo.findAll();
	}
	
	//add a product
	@PostMapping("/")
	public ResponseEntity<Product> create(@RequestBody @Valid Product product){
		Product p = pRepo.save(product);
		  URI productURI = URI.create("/products/" + p.getId());
	        return ResponseEntity.created(productURI).body(p);
	}
}
