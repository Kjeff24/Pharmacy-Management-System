package com.bexos.PharmacyManagementSystem.controllers;


import com.bexos.PharmacyManagementSystem.models.Drug;
import com.bexos.PharmacyManagementSystem.services.interfaces.DrugService;
import com.bexos.PharmacyManagementSystem.services.interfaces.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sale")
public class SaleController {
    private final SaleService saleService;
    private final DrugService drugService;

    @GetMapping("/{drug_id}")
    public String sale(@PathVariable("drug_id") Integer drugId, Model model) {
        Drug drug = drugService.findByDrugId(drugId);
        model.addAttribute("drug", drug);
        return "sell_drug";
    }

    @GetMapping("/history")
    public String productHistory(){
        return "sales_history";
    }
}
