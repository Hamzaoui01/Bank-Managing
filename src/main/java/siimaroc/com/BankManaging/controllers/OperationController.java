package siimaroc.com.BankManaging.controllers;

import org.springframework.web.bind.annotation.*;
import siimaroc.com.BankManaging.DTOs.OperationDTO;
import siimaroc.com.BankManaging.DTOs.TransferMoneyDTO;
import siimaroc.com.BankManaging.services.BankService;

@RestController
@RequestMapping(value = "/operations")
public class OperationController {

    private final BankService bankService;

    OperationController(BankService bankService){ this.bankService = bankService;}

    @GetMapping
    public String getOperationsDenied(){
        return "Operation denied";
    }

    @PostMapping(value = "/credit")
    public void creditMoneyToAccount(@RequestBody OperationDTO operationDTO){
        bankService.creditAccount(operationDTO.getAccountNumber(),operationDTO.getAmount());
    }

    @PutMapping(value = "/debit")
    public void debitMoneyFromAccount(@RequestBody  OperationDTO operationDTO){
        bankService.debitAccount(operationDTO.getAccountNumber(),operationDTO.getAmount());
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferMoneyDTO transferMoneyDTO){
        bankService.transferMoney(transferMoneyDTO);
    }
}
