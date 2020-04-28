package siimaroc.com.BankManaging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import siimaroc.com.BankManaging.DTOs.AccountDTO;
import siimaroc.com.BankManaging.DTOs.OperationDTO;
import siimaroc.com.BankManaging.DTOs.TransferMoneyDTO;
import siimaroc.com.BankManaging.entities.Account;
import siimaroc.com.BankManaging.entities.Client;
import siimaroc.com.BankManaging.repositories.ClientRepository;
import siimaroc.com.BankManaging.services.BankService;

import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    private final BankService bankService;

   AccountController(BankService bankService){ this.bankService = bankService;}

    @PostMapping(value = "/new")
    public void createAccount(@RequestBody AccountDTO accountDTO){
        bankService.createAccount(accountDTO.getClientId(),accountDTO.getBalance(),accountDTO.getCurrency());
    }

}
