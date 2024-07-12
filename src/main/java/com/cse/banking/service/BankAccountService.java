package com.cse.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cse.banking.entity.BankAccount;
import com.cse.banking.repository.BankAccountRepository;

@Service
public class BankAccountService {
    
    @Autowired
    private BankAccountRepository bankAccountRepository;
    
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }
    
    public BankAccount getBankAccountById(Long id) {
        return bankAccountRepository.findById(id).orElseThrow();
    }
    
    public BankAccount createBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }
    
    public BankAccount updateBankAccount(Long id, BankAccount bankAccount) {
        BankAccount existingBankAccount = getBankAccountById(id);
        existingBankAccount.setAccountNumber(bankAccount.getAccountNumber());
        existingBankAccount.setAccountHolderName(bankAccount.getAccountHolderName());
        existingBankAccount.setBalance(bankAccount.getBalance());
        return bankAccountRepository.save(existingBankAccount);
    }
    
    public void deleteBankAccount(Long id) {
        bankAccountRepository.deleteById(id);
    }
}