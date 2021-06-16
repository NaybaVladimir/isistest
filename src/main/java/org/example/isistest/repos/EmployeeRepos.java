package org.example.isistest.repos;

import org.example.isistest.models.Bank;
import org.example.isistest.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepos extends JpaRepository<Employee,Long> {
    Employee findEmployeeById(Long id);
    List<Employee> findAllByBank(Bank bank);
}