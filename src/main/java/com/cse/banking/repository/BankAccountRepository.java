package com.cse.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cse.banking.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    
}