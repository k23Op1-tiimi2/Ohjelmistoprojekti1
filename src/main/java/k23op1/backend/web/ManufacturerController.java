package k23op1.backend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import k23op1.backend.domain.Manufacturer;
import k23op1.backend.domain.ManufacturerRepository;

@Controller
public class ManufacturerController {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    // valmistajalistaus
    @RequestMapping(value = "/manufacturerlist", method = RequestMethod.GET)
    public String manufacturerList(Model model) {
        List<Manufacturer> manufacturers = (List<Manufacturer>) manufacturerRepository.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "addmanufacturer";
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
}
