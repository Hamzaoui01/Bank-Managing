package siimaroc.com.BankManaging.services;

import siimaroc.com.BankManaging.DTOs.TransferMoneyDTO;

public interface BankService {
    public void creditAccount(String accountNumber,double creditAmount);
    public void debitAccount(String accountNumber, double debitAmount);
    public void createAccountForClient(long clientId,double balance,String currency);
    void transferMoney(TransferMoneyDTO transferMoneyDTO);
}
