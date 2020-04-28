package siimaroc.com.BankManaging.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client implements Serializable {
    @Id @GeneratedValue
    private long id;
    private String name;
    private String email;
    private String telephone;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<Account> accountList = new ArrayList<>();

    public Client(String name,String email,String telephone){
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public void addAccount(Account account){
        this.accountList.add(account);
    }
}
