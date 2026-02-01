package com.bus.bus_tracker.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// page controler vraca HTML stranicu za prikaz mape
@Controller
public class MapController {
    @GetMapping("/live")
    public String liveMap() {
        return "live_map";
    }
}