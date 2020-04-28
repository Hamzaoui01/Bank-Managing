package siimaroc.com.BankManaging.services;

import org.springframework.stereotype.Service;
import siimaroc.com.BankManaging.DTOs.TransferMoneyDTO;
import siimaroc.com.BankManaging.entities.Account;
import siimaroc.com.BankManaging.entities.Client;
import siimaroc.com.BankManaging.entities.Operation;
import siimaroc.com.BankManaging.repositories.AccountRepository;
import siimaroc.com.BankManaging.repositories.ClientRepository;
import siimaroc.com.BankManaging.repositories.OperationRepository;

import javax.persistence.Id;

@Service
public class BankServiceImpl implements BankService{

    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;
    private final OperationRepository operationRepository;

    public BankServiceImpl(ClientRepository clientRepository,AccountRepository accountRepository,OperationRepository operationRepository){
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }

    @Override
    public void creditAccount(String accountNumber, double creditAmount) {
        Account account = getAccount(accountNumber);
        account.creditAccount(creditAmount);
        Operation operation = new Operation("Credit",account,creditAmount);
        operationRepository.save(operation);
    }

    public Account getAccount(String accountNumber) {
        return  accountRepository.findByNumber(accountNumber);
    }

    @Override
    public void debitAccount(String accountNumber, double debitAmount) {
        Account account = accountRepository.findByNumber(accountNumber);
        account.debitAccount(debitAmount);
        Operation operation = new Operation("Debit",account,debitAmount);
        operationRepository.save(operation);
    }

    @Override
    public void createAccount(long clientId, double balance, String currency) {
        Client client = clientRepository.getOne(clientId);
        Account account = new Account(client,balance,currency);
        account = saveAccount(account);
        client.addAccount(account);
        clientRepository.save(client);
    }

    private Account saveAccount(Account account) {
        account =accountRepository.save(account);
        account.setAccountNumber(""+account.getId());
        accountRepository.save(account);
        return account;
    }

    @Override
    public void createClient(String name, String email, String telephone) {
        Client client = new Client(name,email,telephone);
        clientRepository.save(client);
    }

    @Override
    public void transferMoney(TransferMoneyDTO transferMoneyDTO) {
        debitAccount(transferMoneyDTO.getSenderAccountNumber(),transferMoneyDTO.getAmount());
        creditAccount(transferMoneyDTO.getReceiverAccountNumber(),transferMoneyDTO.getAmount());
    }
}
