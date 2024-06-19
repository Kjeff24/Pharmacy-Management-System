package com.bexos.PharmacyManagementSystem.controllers;


import com.bexos.PharmacyManagementSystem.dtos.SaleDto;
import com.bexos.PharmacyManagementSystem.dtos.SalesResponseDto;
import com.bexos.PharmacyManagementSystem.models.Drug;
import com.bexos.PharmacyManagementSystem.repositories.SaleRepository;
import com.bexos.PharmacyManagementSystem.services.interfaces.DrugService;
import com.bexos.PharmacyManagementSystem.services.interfaces.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Controller for handling sale-related operations.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/sale")
public class SaleController {
    private final SaleService saleService;
    private final DrugService drugService;
    private final SaleRepository saleRepository;

    /**
     * Displays the form to sell a drug.
     *
     * @param drugId Id of the drug to be sold.
     * @param model  Model object to add SaleDto for form binding.
     * @return View name "sell_drug" to sell a drug.
     */
    @GetMapping("/{drug_id}")
    public String sale(@PathVariable("drug_id") Integer drugId, Model model) {
        Drug drug = drugService.findByDrugId(drugId);
        SaleDto sale = SaleDto.builder()
                .drugId(drug.getId())
                .drugName(drug.getName())
                .drugQuantity(drug.getQuantity())
                .drugPrice(drug.getPrice())
                .build();
        model.addAttribute("sale", sale);
        return "sell_drug";
    }

    /**
     * Handles submission of the drug sale form.
     *
     * @param drugId             Id of the drug being sold.
     * @param dto                SaleDto object containing sale information.
     * @param redirectAttributes RedirectAttributes for flash messages.
     * @return Redirects to "/sale/{drug_id}" after selling drug with success message.
     */
    @PostMapping("/add/{drug_id}")
    public String addDrug(@PathVariable("drug_id") Integer drugId, @ModelAttribute("sale") SaleDto dto, RedirectAttributes redirectAttributes) {
        System.out.println("day 1");
        saleService.sellDrug(drugId, dto);
        redirectAttributes.addFlashAttribute("message", "Drug Sold!");
        return "redirect:/sale/" + drugId;
    }

    /**
     * Displays the sales history with optional filtering by buyer.
     *
     * @param query Optional query string to filter sales by buyer.
     * @param model Model object to add sales for rendering in view.
     * @return View name "sales_history" displaying sales based on query.
     */
    @GetMapping("/history")
    public String productHistory(@RequestParam(name = "query", required = false) String query, Model model) {
        List<SalesResponseDto> sales;

        if (query != null && !query.isEmpty()) {
            sales = saleService.findByBuyer(query);
        } else {
            sales = saleService.findAllSales();
        }
        model.addAttribute("sales", sales);
        return "sales_history";
    }

    /**
     * Deletes a sale based on saleId.
     *
     * @param saleId             Id of the sale to delete.
     * @param redirectAttributes RedirectAttributes for flash messages.
     * @return Redirects to "/sale/history" after deleting sale with success message.
     */
    @GetMapping("/delete/{sale_id}")
    public String deleteSale(@PathVariable("sale_id") Integer saleId, RedirectAttributes redirectAttributes) {
        if (!saleRepository.existsById(saleId)) {
            redirectAttributes.addFlashAttribute("message", "Sales do not exist!");
        }
        saleService.deleteBySaleId(saleId);
        redirectAttributes.addFlashAttribute("message", "Sales Deleted!");
        return "redirect:/sale/history";
    }
}
