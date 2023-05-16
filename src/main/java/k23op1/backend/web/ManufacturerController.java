package k23op1.backend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import k23op1.backend.domain.Manufacturer;
import k23op1.backend.domain.ManufacturerRepository;
import k23op1.backend.domain.Product;
import k23op1.backend.domain.ProductRepository;

@Controller
public class ManufacturerController {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

   @Autowired ProductRepository productRepository;
   
    // valmistajalistaus
    @RequestMapping(value = "/manufacturerlist", method = RequestMethod.GET)
    public String manufacturerList(Model model) {
        List<Manufacturer> manufacturers = (List<Manufacturer>) manufacturerRepository.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "manufacturerlist";
    }

    
    
    
    
    
    
    
    
    
    
    // valmistajan lisääminen
    @RequestMapping(value = "/addmanufacturer")
    public String createManufacturer(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "addmanufacturer";
    }

    // tallenna
    @RequestMapping(value = "/savemanufacturer", method = RequestMethod.POST)
    public String saveManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
        return "redirect:manufacturerlist";
    }

    
    
    @GetMapping("/editmanufacturer/{manufacturerid}")
public String showEditForm(@PathVariable("manufacturerid") Long manufacturerId, Model model) {
    Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer ID: " + manufacturerId));
    model.addAttribute("manufacturer", manufacturer);
    return "editmanufacturer";
}

@PostMapping("/editmanufacturer/{manufacturerid}")
public String editManufacturer(@Valid @ModelAttribute("manufacturer") Manufacturer manufacturer,
                               BindingResult bindingResult,
                               @PathVariable("manufacturerid") Long manufacturerId,
                               Model model) {
    if (bindingResult.hasErrors()) {
        
        return "editmanufacturer";
    }
    manufacturerRepository.save(manufacturer);
    return "redirect:/manufacturerlist";
}
 
    
    
    
    
    
    
    
@RequestMapping(value = "/deletemanufacturer/{manufacturerid}", method = RequestMethod.GET)
public String deleteManufacturer(@PathVariable("manufacturerid") Long manufacturerId, Model model) {
    Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer ID: " + manufacturerId));
      
    List<Product> products = productRepository.findByManufacturer(manufacturer);
    if (!products.isEmpty()) {
        // If the manufacturer is associated with any products, set an error message and redirect back to the manufacturer list page
        model.addAttribute("errorMessage", "The Manufacturer is associated with " + products.size() + " Product(s) and cannot be deleted.");
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "manufacturerlist";
    }

    manufacturerRepository.deleteById(manufacturerId);

    return "redirect:/manufacturerlist";
}














}
