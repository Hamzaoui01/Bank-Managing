package siimaroc.com.BankManaging.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import siimaroc.com.BankManaging.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
