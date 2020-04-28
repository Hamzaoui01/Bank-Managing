package siimaroc.com.BankManaging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import siimaroc.com.BankManaging.DTOs.TransferMoneyDTO;
import siimaroc.com.BankManaging.services.BankServiceImpl;

@Controller
@RepositoryRestResource(path = "/bank")
public class BankController {

    private BankServiceImpl bankService = new BankServiceImpl();

    @PutMapping(value = "/credits/{accountNumber}")
    public void creditMoneyToAccount(@PathVariable(value = "accountNumber") String accountNumber, @RequestBody double creditAmount){
        bankService.creditAccount(accountNumber,creditAmount);
    }

    @PutMapping(value = "/debits/{accountNumber}")
    public void debitMoneyFromAccount(@PathVariable(value = "accountNumber") String accountNumber, @RequestBody double debitAmount){
        bankService.debitAccount(accountNumber,debitAmount);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferMoneyDTO transferMoneyDTO){
        bankService.transferMoney(transferMoneyDTO);
    }

}
