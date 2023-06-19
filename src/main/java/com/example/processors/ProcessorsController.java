package com.example.processors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProcessorController {

    @GetMapping
    public String showInputPage() {
        return "input";
    }

    @PostMapping("/submit")
    public String processForm(
            @RequestParam("processorName") String processorName,
            @RequestParam(value = "manufacturer", defaultValue = "Intel") String manufacturer,
            @RequestParam(value = "windows11Ready", required = false, defaultValue = "false") boolean windows11Ready,
            Model model
    ) {
        if (processorName.isEmpty()) {
            model.addAttribute("error", "Processor Name is required.");
            return "input";
        }

        model.addAttribute("processorName", processorName);
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("windows11Ready", windows11Ready);
        return "output";
    }
}
