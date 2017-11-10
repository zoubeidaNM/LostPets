package com.example.lostpets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class JavaController {

    @Autowired
    PetRepository petRepository;

    @RequestMapping("/")
    public String listPets(Model model){
        model.addAttribute("pets", petRepository.findAll());
        return "list";
    }

    @RequestMapping("/modify")
    public String listPetsForUpdate(Model model){
        model.addAttribute("pets", petRepository.findAll());
        return "modify";
    }

    @RequestMapping("/delete")
    public String listPetsForDelete(Model model){
        model.addAttribute("pets", petRepository.findAll());
        return "delete";
    }

    @GetMapping("/add")
    public String petForm(Model model){
        model.addAttribute("pet", new Pet());
        return "petform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Pet pet, BindingResult result){
        if(result.hasErrors()){
            return "petform";
        }

        petRepository.save(pet);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showPet(@PathVariable("id") long id, Model model){
        model.addAttribute("pet", petRepository.findOne(id));
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updatePet(@PathVariable("id") long id, Model model){
        model.addAttribute("pet", petRepository.findOne(id));
        return "petform";
    }

    @RequestMapping("/delete/{id}")
    public String delPet(@PathVariable("id") long id, Model model){
        petRepository.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/search")
    public String getSearchString(){
        return "search";
    }

    @PostMapping("/searchlist")
    public String searchRepository(@RequestParam String searchStr, Model model){

        List<Pet> list = petRepository.findAllByNameContains(searchStr);
        model.addAttribute("list", list);
        return "searchlist";
    }

    @RequestMapping("/home")
    public String goHome(){
        return "home";
    }
}
