package org.example.isistest.controllers;

import lombok.RequiredArgsConstructor;
import org.example.isistest.models.Employee;
import org.example.isistest.repos.BankRepo;
import org.example.isistest.repos.EmployeeRepos;
import org.example.isistest.repos.PositionRepos;
import org.example.isistest.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeRepos employeeRepos;
    private final BankRepo bankRepo;
    private final PositionRepos positionRepos;
    private final EmployeeService employeeService;


    @GetMapping()
    public String mainEmployee(@RequestParam(name = "sortDateOt", required = false) String sortDateOt,
                               @RequestParam(name = "sortDateDo", required = false) String sortDateDo,
                               @RequestParam(name = "fio", required = false) String fio,
                               Model model) {
        var employees = employeeService.filter(sortDateOt, sortDateDo, fio);

        model.addAttribute("employees", employees);

        return "employee/mainEmploye";
    }


    @GetMapping("/newEmployee")
    public String newEmployee(Map<String, Object> map) {
        map.put("employee", new Employee());
        map.put("bank", bankRepo.findAll());
        map.put("position", positionRepos.findAll());
        return "employee/newEmployee";
    }

    @PostMapping()
    public String create(@ModelAttribute("employee") Employee employee) {
        employeeRepos.save(employee);

        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    public String edit(Map<String, Object> map, @PathVariable("id") Long id) {
        map.put("employee", employeeRepos.findEmployeeById(id));
        map.put("bank", bankRepo.findAll());
        map.put("position", positionRepos.findAll());
        return "employee/editEmployee";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("employee") Employee employee) {
        employeeRepos.save(employee);
        return "redirect:/employee";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {

        employeeRepos.delete(employeeRepos.findEmployeeById(id));

        return "redirect:/employee";
    }

//    @PostMapping("/sortDate")
//    public String sortDate(@PathVariable("sortDateOt") String sortDateOt,
//                           @PathVariable("sortDateDo") String sortDateDo,
//                           Model model) {
//        System.out.println("Даты: " + sortDateDo + sortDateOt);
//        try {
//            Date dateOt = new SimpleDateFormat("yyyy-MM-dd").parse(sortDateOt);
//            Date dateDo = new SimpleDateFormat("yyyy-MM-dd").parse(sortDateDo);
//
//
//            var listEmployee = employeeRepos.findAll();
//            var employeesHB = new ArrayList<>();
//            for (Employee el : listEmployee) {
//                if (new SimpleDateFormat("yyyy-MM-dd").parse(el.getDateBirthday()).after(dateOt) &&
//                        (new SimpleDateFormat("yyyy-MM-dd").parse(el.getDateBirthday())).before(dateDo)) {
//                    employeesHB.add(el);
//                }
//            }
//            model.addAttribute("employees", employees);
//            System.out.println("Даты: " + dateOt + dateDo);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        return "employee/mainEmploye";
//    }

}
