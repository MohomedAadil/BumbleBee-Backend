package com.example.backendb.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "installments")
public class Installment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long creditor;

    @Column(name = "loan_balance")
    private BigDecimal loanBalance;

    @Column(name = "used_amount")
    private BigDecimal usedAmount;

    @Column(name = "installment_plan")
    private String installmentPlan;

    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return creditor;
    }

    public void setCustomerId(Long creditor) {
        this.creditor = creditor;
    }

    public BigDecimal getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(BigDecimal loanBalance) {
        this.loanBalance = loanBalance;
    }

    public BigDecimal getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(BigDecimal usedAmount) {
        this.usedAmount = usedAmount;
    }

    public String getInstallmentPlan() {
        return installmentPlan;
    }

    public void setInstallmentPlan(String installmentPlan) {
        this.installmentPlan = installmentPlan;
    }
}
