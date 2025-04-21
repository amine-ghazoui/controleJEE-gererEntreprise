package org.example.controlejeegererentreprise.web;

import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.example.controlejeegererentreprise.entities.Entreprise;
import org.example.controlejeegererentreprise.repositories.EntrepriseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class EntrepriseController {

    EntrepriseRepository entrepriseRepository;

    @GetMapping(path = "/index")
    public String entreprise(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {

        Page<Entreprise> pagePatients = entrepriseRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("ListePatients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("pageCurrent", page);
        model.addAttribute("keyword", keyword);

        return "entreprise";
    }


    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page){

        entrepriseRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }


    @GetMapping("/formeEntreprise")
    public String formPatient(Model model){
        model.addAttribute("entreprise", new Entreprise());
        return "formeEntreprise";
    }

    @PostMapping("/saveEntreprise")
    public String save(Model model, @Valid Entreprise entreprise, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()){
            return "formeEntreprise";
        }
        entrepriseRepository.save(entreprise);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
}
