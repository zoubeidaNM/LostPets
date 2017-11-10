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
    public String listPets(Model model) {
        model.addAttribute("pets", petRepository.findAll());
        return "list";
    }

    @RequestMapping("/modify")
    public String listPetsForUpdate(Model model) {
        model.addAttribute("pets", petRepository.findAll());
        return "modify";
    }

    @RequestMapping("/delete")
    public String listPetsForDelete(Model model) {
        model.addAttribute("pets", petRepository.findAll());
        return "delete";
    }

    @GetMapping("/add")
    public String petForm(Model model) {
        model.addAttribute("pet", new Pet());
        return "petform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Pet pet, BindingResult result) {
        if (result.hasErrors()) {
            return "petform";
        }

        petRepository.save(pet);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showPet(@PathVariable("id") long id, Model model) {
        model.addAttribute("pet", petRepository.findOne(id));
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updatePet(@PathVariable("id") long id, Model model) {
        model.addAttribute("pet", petRepository.findOne(id));
        return "petform";
    }

    @RequestMapping("/delete/{id}")
    public String delPet(@PathVariable("id") long id, Model model) {
        petRepository.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/search")
    public String getSearchString() {
        return "search";
    }

    @PostMapping("/searchlist")
    public String searchRepository(@RequestParam String searchfield,
                                   @RequestParam String searchStr, Model model) {

        if (searchfield.equalsIgnoreCase("name")) {
            List<Pet> list = petRepository.findAllByNameContains(searchStr);
            model.addAttribute("list", list);
            model.addAttribute("field","name");
            model.addAttribute("searchstr", searchStr);
        } else if (searchfield.equalsIgnoreCase("age")) {
            List<Pet> list = petRepository.findAllByAgeContains(searchStr);
            model.addAttribute("list", list);
            model.addAttribute("field","age");
            model.addAttribute("searchstr", searchStr);
        } else if (searchfield.equalsIgnoreCase("type")) {
            List<Pet> list = petRepository.findAllByTypeContains (searchStr);
            model.addAttribute("list", list);
            model.addAttribute("field","type");
            model.addAttribute("searchstr", searchStr);
        } else if (searchfield.equalsIgnoreCase("breed")) {
            List<Pet> list = petRepository.findAllByBreedContains(searchStr);
            model.addAttribute("list", list);
            model.addAttribute("field","breed");
            model.addAttribute("searchstr", searchStr);
        } else if (searchfield.equalsIgnoreCase("color")) {
            List<Pet> list = petRepository.findAllByColorContains(searchStr);
            model.addAttribute("list", list);
            model.addAttribute("field","color");
            model.addAttribute("searchstr", searchStr);
        } else if (searchfield.equalsIgnoreCase("features")) {
            List<Pet> list = petRepository.findAllByFeaturesContains(searchStr);
            model.addAttribute("list", list);
            model.addAttribute("field","features");
            model.addAttribute("searchstr", searchStr);
        } else if (searchfield.equalsIgnoreCase("phone")) {
            List<Pet> list = petRepository.findAllByPhoneContains(searchStr);
            model.addAttribute("list", list);
            model.addAttribute("field","phone");
            model.addAttribute("searchstr", searchStr);
        } else if (searchfield.equalsIgnoreCase("currentstatus")) {
            List<Pet> list = petRepository.findAllByCurrentStatusContains(searchStr);
            model.addAttribute("field","status");
            model.addAttribute("list", list);
            model.addAttribute("searchstr", searchStr);
        }
             return "searchlist";
        }

        @RequestMapping("/home")
        public String goHome () {
            return "home";
        }
    }
