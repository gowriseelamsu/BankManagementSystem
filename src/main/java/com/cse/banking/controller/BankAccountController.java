package com.cse.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cse.banking.entity.BankAccount;
import com.cse.banking.service.BankAccountService;

@RestController
@RequestMapping("/bank-accounts")
public class BankAccountController {
    
    @Autowired
    private BankAccountService bankAccountService;
    @GetMapping("/read-accounts")
    public String getAllBankAccounts(@RequestParam(value = "search-id", required = false) Long searchId, Model model) {
        if (searchId != null) {
            BankAccount account = bankAccountService.getBankAccountById(searchId);
            if (account != null) {
                return "redirect:/bank-accounts/" + searchId;
            }
        }
        List<BankAccount> accounts = bankAccountService.getAllBankAccounts();
        model.addAttribute("accounts", accounts);
        return "read-accounts";
    }
    @GetMapping
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }
    
    @GetMapping("/{id}")
    public BankAccount getBankAccountById(@PathVariable Long id) {
        return bankAccountService.getBankAccountById(id);
    }
    @GetMapping("/update-account/{id}")
    public String updateBankAccountForm(@PathVariable Long id, Model model) {
        BankAccount account = bankAccountService.getBankAccountById(id);
        model.addAttribute("bankAccount", account);
        return "update-account";
    }
    @RequestMapping(value = "/create-account", method = RequestMethod.POST)
    public String createBankAccount(@ModelAttribute("bankAccount") BankAccount bankAccount) {
        bankAccountService.createBankAccount(bankAccount);
        return "Created";
    }
    @GetMapping("/create-account")
    public String createBankAccountForm(Model model) {
        model.addAttribute("bankAccount", new BankAccount());
        return "create-account";
    }
    @RequestMapping(value = "/update-account/{id}", method = RequestMethod.PUT)
    public String updateBankAccount(@PathVariable Long id, @ModelAttribute("bankAccount") BankAccount bankAccount) {
    	bankAccountService.updateBankAccount(id, bankAccount);
        return "updated";
    }
    
    @DeleteMapping("/{id}")
    public void deleteBankAccount(@PathVariable Long id) {
        bankAccountService.deleteBankAccount(id);
    }
}