package org.example.isistest.controllers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.isistest.models.Bank;
import org.example.isistest.models.Employee;
import org.example.isistest.repos.BankRepo;
import org.example.isistest.repos.EmployeeRepos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bank")
public class BankController {
    private final BankRepo bankRepo;
    private final EmployeeRepos employeeRepos;

    @GetMapping()
    public String main(Model model) {
        var bank=bankRepo.findAll();
        model.addAttribute("bank", bank);
        return "bank/mainBank";
    }


    @GetMapping("/newBank")
    public String newBank(Model model) {
        model.addAttribute("bank", new Bank());
        return "bank/newBank";
    }

    @PostMapping()
    public String create(@ModelAttribute("bank") Bank bank) {
        bankRepo.save(bank);
        return "redirect:/bank";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("bank", bankRepo.findBankById(id));
        return "bank/editBank";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("bank") Bank bank){
        bankRepo.save(bank);
        return "redirect:/bank";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){

        bankRepo.delete(bankRepo.findBankById(id));

        return "redirect:/bank";
    }
    @GetMapping("/{id}/list")
    public String list(@PathVariable("id") Long id, Model model){

        model.addAttribute("employee", employeeRepos.findAllByBank(bankRepo.findBankById(id)));

        return "bank/list";
    }
}
