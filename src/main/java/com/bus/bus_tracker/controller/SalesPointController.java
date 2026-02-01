package com.bus.bus_tracker.controller;

import com.bus.bus_tracker.dto.SalesPointRequestDto;
import com.bus.bus_tracker.service.SalesPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/sales-points")
public class SalesPointController {

    private final SalesPointService service;

    @GetMapping
    public String page(Model model) {
        // dohvat svih prodajnih mjesta iz baze
        model.addAttribute("salesPoints", service.getAll());
        // vraća admin Thymeleaf template (lista + forma)
        return "sales_points";
    }

    @PostMapping
    public String create(@ModelAttribute SalesPointRequestDto dto) {
        // kreiranje novog prodajnog mjesta iz podataka forme
        service.create(dto);
        return "redirect:/admin/sales-points";
    }


    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        // brisanje prodajnog mjesta po ID-u
        service.delete(id);
        // povratak na admin listu
        return "redirect:/admin/sales-points";
    }
}
