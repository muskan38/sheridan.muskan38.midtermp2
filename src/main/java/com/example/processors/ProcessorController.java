package com.example.processors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProcessorController {
    @GetMapping("/input")
    public String showInputPage() {
        return "input";
    }

    @PostMapping("/submit")
    public String processInput(
            @RequestParam("processorName") String processorName,
            @RequestParam("manufacturer") String manufacturer,
            @RequestParam(value = "windows11Ready", required = false) boolean windows11Ready,
            Model model) {
        if (processorName.isEmpty()) {
            model.addAttribute("error", "Processor Name cannot be empty!");
            return "input";
        }

        model.addAttribute("processorName", processorName);
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("windows11Ready", windows11Ready);

        return "output";
    }
}
