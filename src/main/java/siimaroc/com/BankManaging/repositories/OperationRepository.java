package siimaroc.com.BankManaging.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import siimaroc.com.BankManaging.entities.Operation;

public interface OperationRepository extends JpaRepository <Operation,Long> {
}
