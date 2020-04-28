package siimaroc.com.BankManaging.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import siimaroc.com.BankManaging.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
