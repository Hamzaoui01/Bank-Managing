package siimaroc.com.BankManaging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import siimaroc.com.BankManaging.DTOs.AccountDTO;
import siimaroc.com.BankManaging.DTOs.OperationDTO;
import siimaroc.com.BankManaging.DTOs.TransferMoneyDTO;
import siimaroc.com.BankManaging.entities.Client;
import siimaroc.com.BankManaging.repositories.ClientRepository;
import siimaroc.com.BankManaging.services.BankService;
import siimaroc.com.BankManaging.services.BankServiceImpl;

@RestController
@RequestMapping(value = "/bank-manager")
public class BankController {

    private final BankService bankService;

    BankController(BankService bankService){ this.bankService = bankService;}

    @PostMapping(value = "/credits")
    public void creditMoneyToAccount(@RequestBody OperationDTO operationDTO){
        bankService.creditAccount(operationDTO.getAccountNumber(),operationDTO.getAmount());
    }

    @PutMapping(value = "/debits")
    public void debitMoneyFromAccount(@RequestBody  OperationDTO operationDTO){
        bankService.debitAccount(operationDTO.getAccountNumber(),operationDTO.getAmount());
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferMoneyDTO transferMoneyDTO){
        bankService.transferMoney(transferMoneyDTO);
    }

    @PostMapping("/accounts")
    public void createAccount(@RequestBody AccountDTO accountDTO){
        System.out.println(accountDTO);
        bankService.createAccount(accountDTO.getClientId(),accountDTO.getBalance(),accountDTO.getCurrency());
    }

    @GetMapping
    public String getHello(){
        return "OK";
    }
}
