package com.bexos.PharmacyManagementSystem.controllers;

import com.bexos.PharmacyManagementSystem.dtos.DrugDto;
import com.bexos.PharmacyManagementSystem.models.Drug;
import com.bexos.PharmacyManagementSystem.services.interfaces.DrugService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DrugController {
    private final DrugService drugService;

    @GetMapping
    public String index(Model model){
        List<Drug> drugs = drugService.findAllDrugs();
        model.addAttribute("drugs", drugs);
        return "index";
    }

    @GetMapping("/add-product")
    public String addDrug(Model model){
        DrugDto drug = DrugDto.builder().build();
        model.addAttribute("drug", drug);
        return "add_product";
    }

    @PostMapping("/add-product")
    public String addDrug(@ModelAttribute("drug") DrugDto drug, RedirectAttributes redirectAttributes){
        drugService.addDrug(drug);
        redirectAttributes.addFlashAttribute("message", "Product added!");
        return "redirect:/add-product";
    }

    @GetMapping("/product-history")
    public String productHistory(){
        return "product_history";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "testing 2";
    }
}
