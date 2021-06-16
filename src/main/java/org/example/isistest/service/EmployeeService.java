package org.example.isistest.service;

import lombok.RequiredArgsConstructor;
import org.example.isistest.models.Employee;
import org.example.isistest.repos.EmployeeRepos;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepos employeeRepos;

    public List<Employee> filter(String sortDateOt, String sortDateDo, String fio) {

        var employesAll = employeeRepos.findAll();
        List<Employee> employees;
        if (sortDateOt != null && sortDateOt.length() > 2) {
            if (sortDateDo != null && sortDateDo.length() > 2) {
                employees = filterDB(sortDateOt, sortDateDo, employesAll);
                return employees;
            }
        }
        if (fio != null && fio.length() > 2) {
            employees = filterFio(fio, employesAll);
            return employees;
        }

        return employesAll;
    }

    public List<Employee> filterDB(String sortDateOt, String sortDateDo, List<Employee> employeesAll) {
        List<Employee> employees = new ArrayList<>();

        Date dateOt;
        Date dateDo;
        try {
            dateOt = new SimpleDateFormat("yyyy-MM-dd").parse(sortDateOt);
            dateDo = new SimpleDateFormat("yyyy-MM-dd").parse(sortDateDo);
            for (Employee el : employeesAll) {
                if (new SimpleDateFormat("yyyy-MM-dd").parse(el.getDateBirthday()).after(dateOt) &&
                        (new SimpleDateFormat("yyyy-MM-dd").parse(el.getDateBirthday())).before(dateDo)) {
                    employees.add(el);
                }
            }
        } catch (ParseException e) {
            System.out.println("error pars");
        }
        return employees;
    }

    public List<Employee> filterFio(String fio, List<Employee> employeesAll) {
        List<Employee> employees = new ArrayList<>();
        String[] initials = fio.split(" ");

        for (Employee el : employeesAll) {
            switch (initials.length) {
                case (1):
                    if ((el.getName().trim()).equals(initials[0]) || (el.getSurname().trim()).equals(initials[0]) || (el.getPatronymic().trim()).equals(initials[0])) {
                        employees.add(el);
                    }
                    break;
                case (2):
                    if ((el.getName().trim()).equals(initials[0]) || (el.getSurname().trim()).equals(initials[0]) || (el.getPatronymic().trim()).equals(initials[0])) {
                        if ((el.getName().trim()).equals(initials[1]) || (el.getSurname().trim()).equals(initials[1]) || (el.getPatronymic().trim()).equals(initials[1])) {
                            employees.add(el);
                        }
                    }
                    break;
                case (3):
                    if ((el.getName().trim()).equals(initials[0]) || (el.getSurname().trim()).equals(initials[0]) || (el.getPatronymic().trim()).equals(initials[0])) {
                        if ((el.getName().trim()).equals(initials[1]) || (el.getSurname().trim()).equals(initials[1]) || (el.getPatronymic().trim()).equals(initials[1])) {
                            if ((el.getName().trim()).equals(initials[2]) || (el.getSurname().trim()).equals(initials[2]) || (el.getPatronymic().trim()).equals(initials[2])) {
                                employees.add(el);
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return employees;
    }
}
