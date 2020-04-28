package siimaroc.com.BankManaging.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor

public  class Operation implements Serializable {

    @Id @GeneratedValue
    private Long id;
    private Date dateOperation;
    private double amount;
    private String typeOperation;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    public Operation(String typeOperation, Account account,double amount){
        this.dateOperation = new Date();
        this.amount = amount;
        this.account = account;
        this.typeOperation = typeOperation;
    }

}
