package siimaroc.com.BankManaging.DTOs;

import lombok.Getter;

@Getter
public class TransferMoneyDTO {
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private double amount;
    private String currency;
}
