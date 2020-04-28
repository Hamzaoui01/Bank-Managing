package siimaroc.com.BankManaging.DTOs;

import lombok.Getter;

@Getter
public class OperationDTO {
    String accountNumber;
    double amount;
    String currency;
}
