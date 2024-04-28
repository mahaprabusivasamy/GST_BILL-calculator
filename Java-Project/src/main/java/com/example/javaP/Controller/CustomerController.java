package com.example.javaP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.example.javaP.Model.Customer;
import com.example.javaP.Service.CustomerService;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {
	public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")

                .allowedOrigins("http://localhost:5173")

                .allowedMethods("GET", "POST", "PUT", "DELETE")

                .allowedHeaders("*")

                .allowCredentials(true);

    }



    @Autowired
    private CustomerService customerService;

    @PostMapping("/post/data")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
    @GetMapping("/get")
	public List<Customer> getAll(){
	    return customerService.getAll();
	}
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        customerService.delete(id);
    }
}
