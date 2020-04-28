package siimaroc.com.BankManaging.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Getter
public class Account implements Serializable {

    private final String BANK_NAME ="CDM";

    @Id @GeneratedValue
    private long id;
    private String accountNumber;
    private double balance;
    private String currency;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private Collection<Operation> operations;

    public Account(Client client,double balance,String currency){
        this.balance = balance;
        this.client = client;
        this.currency = currency;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = this.BANK_NAME+accountNumber;
    }

    public void creditAccount(double creditAmount){
        if (this.balance < creditAmount) throw new RuntimeException("solde insufisant");
        this.balance += creditAmount;
    }

    public void debitAccount(double debitAmount){
        this.balance -= debitAmount;
    }
}
