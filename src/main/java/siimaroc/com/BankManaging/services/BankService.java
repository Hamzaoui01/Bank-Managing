package siimaroc.com.BankManaging.services;

import siimaroc.com.BankManaging.DTOs.TransferMoneyDTO;

public interface BankService {
    public void creditAccount(String accountNumber,double creditAmount);
    public void debitAccount(String accountNumber, double debitAmount);
    public void createAccount(long clientId,double balance,String currency);
    public void createClient(String name,String email,String telephone);
    void transferMoney(TransferMoneyDTO transferMoneyDTO);
}
