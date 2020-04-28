package siimaroc.com.BankManaging.DTOs;

import lombok.Getter;
import siimaroc.com.BankManaging.entities.Account;

@Getter
public class TransferMoneyDTO {
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private double amount;
    private String currency;
}
