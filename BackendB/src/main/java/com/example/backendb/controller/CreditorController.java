package com.example.backendb.controller;

import com.example.backendb.entity.Creditor;
import com.example.backendb.service.CreditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/customers")
public class CreditorController {

    @Autowired
    private CreditorService creditorService;

    @GetMapping("/allCustomers")
    public List<Creditor> getAllCustomers() {
        return creditorService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Creditor getCustomerById(@PathVariable Long id) {
        return creditorService.getCustomerById(id);
    }

    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Creditor creditor) {
        creditorService.addCustomer(creditor);
    }

    @PutMapping("/updateCustomer/{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody Creditor creditor) {
        creditorService.updateCustomer(id, creditor);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        creditorService.deleteCustomer(id);
    }
}
