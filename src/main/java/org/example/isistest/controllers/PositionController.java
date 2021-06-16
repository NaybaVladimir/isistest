package org.example.isistest.controllers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.isistest.models.Bank;
import org.example.isistest.models.Position;
import org.example.isistest.repos.PositionRepos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/position")
public class PositionController {
    private final PositionRepos positionRepos;

    @GetMapping()
    public String main(Model model) {
        var position=positionRepos.findAll();
        model.addAttribute("position", position);
        return "position/mainPosition";
    }


    @GetMapping("/newPosition")
    public String newPosition(Model model) {
        model.addAttribute("position", new Position());
        return "position/newPosition";
    }

    @PostMapping()
    public String create(@ModelAttribute("position") Position position) {
        positionRepos.save(position);
        return "redirect:/position";
    }

    @GetMapping("/{name}/edit")
    public String edit(Model model, @PathVariable("name") String name) {
        model.addAttribute("position", positionRepos.findPositionByName(name));
        return "position/editPosition";
    }
    @PatchMapping("/{name}")
    public String update(@ModelAttribute("position") Position position){
        positionRepos.save(position);
        return "redirect:/position";
    }
    @DeleteMapping("/{name}")
    public String delete(@PathVariable("name") String name){

        positionRepos.delete(positionRepos.findPositionByName(name));

        return "redirect:/position";
    }

}

