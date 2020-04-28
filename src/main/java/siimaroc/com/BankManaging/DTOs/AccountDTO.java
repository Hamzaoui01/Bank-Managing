package siimaroc.com.BankManaging.DTOs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AccountDTO {
    private double balance;
    private String currency;
    private long clientId;
}
