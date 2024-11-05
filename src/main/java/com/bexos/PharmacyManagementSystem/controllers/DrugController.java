package com.bexos.PharmacyManagementSystem.controllers;

import com.bexos.PharmacyManagementSystem.dtos.DrugDto;
import com.bexos.PharmacyManagementSystem.models.Drug;
import com.bexos.PharmacyManagementSystem.repositories.DrugRepository;
import com.bexos.PharmacyManagementSystem.services.interfaces.DrugService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Controller for handling drug-related operations.
 */
@Controller
@RequiredArgsConstructor
public class DrugController {
    private final DrugService drugService;
    private final DrugRepository drugRepository;

    /**
     * Displays a list of drugs based on optional query parameter.
     *
     * @param query Optional query string to filter drugs by name.
     * @param model Model object to add drugs for rendering in view.
     * @return View name "index" displaying drugs based on query.
     */
    @GetMapping({"","/drug"})
    public String index(@RequestParam(name = "query", required = false) String query, Model model){
        List<Drug> drugs;
        if (query != null && !query.isEmpty()) {
            drugs = drugService.findDrugsByName(query);
        } else {
            drugs = drugService.findAllDrugs();
        }
        model.addAttribute("drugs", drugs);
        return "index";
    }

    /**
     * Displays a form to add a new drug.
     *
     * @param model Model object to add DrugDto for form binding.
     * @return View name "add_drug" for adding a new drug.
     */
    @GetMapping("/drug/add")
    public String getDrug(Model model){
        DrugDto drug = DrugDto.builder().build();
        model.addAttribute("drug", drug);
        return "add_drug";
    }

    /**
     * Handles submission of the drug addition form.
     *
     * @param drug DrugDto object containing drug information to add.
     * @param redirectAttributes RedirectAttributes for flash messages.
     * @return Redirects to "/drug/add" after adding drug with success message.
     */
    @PostMapping("/drug/add")
    public String addDrug(@ModelAttribute("drug") DrugDto drug, RedirectAttributes redirectAttributes){
        drugService.addDrug(drug);
        redirectAttributes.addFlashAttribute("message", "Product added!");
        return "redirect:/drug/add";
    }

    /**
     * Displays a form to update an existing drug.
     *
     * @param drugId Id of the drug to update.
     * @param model Model object to add Drug for form binding.
     * @return View name "update_drug" for updating an existing drug.
     */
    @GetMapping("/drug/update/{drug_id}")
    public String getUpdate(@PathVariable("drug_id") Integer drugId, Model model) {
        Drug drug = drugService.findByDrugId(drugId);
        model.addAttribute("drug", drug);
        return "update_drug";
    }

    /**
     * Handles submission of the drug update form.
     *
     * @param drugId Id of the drug to update.
     * @param drug Drug object containing updated drug information.
     * @param redirectAttributes RedirectAttributes for flash messages.
     * @return Redirects to "/drug/update/{drug_id}" after updating drug with success message.
     */
    @PostMapping("/drug/update/{drug_id}")
    public String updateProduct(@PathVariable("drug_id") Integer drugId, @ModelAttribute("drug") Drug drug, RedirectAttributes redirectAttributes) {
        if(!drugRepository.existsById(drugId)){
            redirectAttributes.addFlashAttribute("message", "Product updated!");
        }
        drugService.updateDrug(drugId, drug);
        redirectAttributes.addFlashAttribute("message", "Product updated!");

        return "redirect:/drug/update/"+drugId;
    }

    /**
     * Deletes a drug based on drugId.
     *
     * @param drugId Id of the drug to delete.
     * @param redirectAttributes RedirectAttributes for flash messages.
     * @return Redirects to "/" after deleting drug with success message.
     */
    @GetMapping("/drug/delete/{drug_id}")
    public String deleteDrug(@PathVariable("drug_id") Integer drugId, RedirectAttributes redirectAttributes) {
        if(!drugRepository.existsById(drugId)){
            redirectAttributes.addFlashAttribute("message", "Drug do not exist!");
        }
        drugService.deleteDrugById(drugId);
        redirectAttributes.addFlashAttribute("message", "Drug Deleted!");
        return "redirect:/";
    }
}
