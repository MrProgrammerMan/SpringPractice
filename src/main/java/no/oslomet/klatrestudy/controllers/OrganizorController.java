package no.oslomet.klatrestudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import no.oslomet.klatrestudy.entities.Organizor;
import no.oslomet.klatrestudy.services.OrganizorService;
import java.util.List;

@Controller
public class OrganizorController {
    private final OrganizorService organizorService;

    public OrganizorController(OrganizorService organizorService) {
        this.organizorService = organizorService;
    }

    @PostMapping("/organizors")
    public String createOrganizor(Organizor organizor) {
        organizorService.create(organizor);
        return "redirect:/organizors";
    }

    @GetMapping("/organizors")
    public String showOrganizors(Model model) {
        List<Organizor> organizors = organizorService.getAll();
        model.addAttribute("organizors", organizors);
        return "organizors"; // This should return the name of the view (e.g., "organizors.html")
    }

    @DeleteMapping("/organizors/{id}/delete")
    public String deleteOrganizor(@PathVariable Long id) {
        organizorService.delete(id);
        return "redirect:/organizors";
    }

    @GetMapping("/organizors/{id}/edit")
    public String editOrganizor(@PathVariable Long id, Model model) {
        Organizor organizor = organizorService.getById(id).orElse(null);
        model.addAttribute("organizor", organizor);
        return "edit_organizor"; // This should return the name of the view (e.g., "edit_organizor.html")
    }

    @PutMapping("/organizors/{id}/update")
    public String updateOrganizor(@PathVariable Long id, Organizor organizor) {
        organizorService.update(id, organizor);
        return "redirect:/organizors";
    }
}
