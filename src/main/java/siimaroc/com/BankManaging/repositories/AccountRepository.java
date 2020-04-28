package siimaroc.com.BankManaging.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import siimaroc.com.BankManaging.entities.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query("select a from Account a where a.accountNumber=:x ")
    public Account findByNumber(@Param("x") String AccountNumber);
}
