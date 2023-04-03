package com.example.backendb.repository;

import com.example.backendb.entity.Creditor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditorRepository extends JpaRepository<Creditor, Long> {
}
