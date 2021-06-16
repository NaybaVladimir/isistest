package org.example.isistest.repos;

import org.example.isistest.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank,Long> {
    Bank findBankById(Long id);
}
