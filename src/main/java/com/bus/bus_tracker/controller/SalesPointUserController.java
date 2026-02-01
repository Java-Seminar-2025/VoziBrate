package com.bus.bus_tracker.controller;

import com.bus.bus_tracker.service.SalesPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sales-points")
public class SalesPointUserController {

    private final SalesPointService service;// Service koji dohvaća prodajna mjesta iz baze

    @GetMapping
    public String page(Model model) {
        // dohvat svih prodajnih mjesta iz baze
        model.addAttribute("salesPoints", service.getAll());
        return "sales_points_user"; // vraća Thymeleaf template sales_points_user.html
    }
}
