package com.example.backendb.service;

import com.example.backendb.entity.Creditor;
import com.example.backendb.repository.CreditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditorService {

    @Autowired
    private CreditorRepository creditorRepository;

    public List<Creditor> getAllCustomers() {
        return creditorRepository.findAll();
    }

    public Creditor getCustomerById(Long id) {
        return creditorRepository.findById(id).orElse(null);
    }

    public void addCustomer(Creditor creditor) {
        creditorRepository.save(creditor);
    }

    public void updateCustomer(Long id, Creditor creditor) {
        Creditor existingCreditor = creditorRepository.findById(id).orElse(null);
        if (existingCreditor != null) {
            existingCreditor.setFullName(creditor.getFullName());
            existingCreditor.setDateOfBirth(creditor.getDateOfBirth());
            existingCreditor.setPhonenumber(creditor.getPhonenumber());
            creditorRepository.save(existingCreditor);
        }
    }

    public void deleteCustomer(Long id) {
        creditorRepository.deleteById(id);
    }
}
