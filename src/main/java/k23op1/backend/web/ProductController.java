package k23op1.backend.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import k23op1.backend.domain.Manufacturer;
import k23op1.backend.domain.ManufacturerRepository;
import k23op1.backend.domain.Product;
import k23op1.backend.domain.ProductRepository;

@CrossOrigin()
@Controller
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/")
    public void handleRequest() {
        throw new RuntimeException("Page is not found or it is under construction");
    }

    // Tuotelistaus
    @RequestMapping(value = "/productlist", method = RequestMethod.GET)
    public String productList(Model model) {
        List<Product> products = (List<Product>) productRepository.findAll();
        model.addAttribute("products", products);
        return "productlist";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "addproduct";
    }

    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("productId") Long productId) {
        productRepository.deleteById(productId);
        return "redirect:/productlist";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            log.info("Error");
            model.addAttribute("manufacturers", manufacturerRepository.findAll());
            return "addproduct";
        }
        log.info("product" + product);
        productRepository.save(product);
        return "redirect:/productlist";
    }

    /*
     * @RequestMapping(value = "/save", method = RequestMethod.POST)
     * public String addProduct(Product product) {
     * productRepository.save(product);
     * return "redirect:/productlist";
     * }
     */

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long productId, Model model) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + productId));
        model.addAttribute("product", product);
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "editproduct";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
            @PathVariable("id") Long productId, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("Error");
            model.addAttribute("manufacturers", manufacturerRepository.findAll());
            return "editproduct";
        }
        productRepository.save(product);
        return "redirect:/products";
    }

    /*
     * @RequestMapping(value = "/edit/{productId}", method = RequestMethod.GET)
     * public String editProductForm(@PathVariable("productId") Long productId,
     * Model model) {
     * Product product = productRepository.findById(productId)
     * .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" +
     * productId));
     * model.addAttribute("product", product);
     * return "editproduct";
     * }
     */

    /*
     * @RequestMapping(value = "/editproduct/{productId}", method =
     * RequestMethod.POST)
     * public String editProductSubmit(@PathVariable("productId") Long productId,
     * 
     * @ModelAttribute("product") Product product) {
     * Product existingProduct = productRepository.findById(productId)
     * .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" +
     * productId));
     * existingProduct.setName(product.getName());
     * existingProduct.setType(product.getType());
     * existingProduct.setSize(product.getSize());
     * existingProduct.setColor(product.getColor());
     * existingProduct.setPrice(product.getPrice());
     * 
     * return "redirect:/productlist";
     * }
     */

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String showProduct(@PathVariable("id") Long productId, Model model) {

        model.addAttribute("product", (productRepository.findById(productId)).get());
        return "product";

    }

    @RequestMapping(value = "/manufacturer/{id}", method = RequestMethod.GET)
    public String showManufacturer(@PathVariable("id") Long productId, Model model) {

        model.addAttribute("manufacturer", (productRepository.findById(productId)).get());
        return "product";

    }

    @GetMapping("/productsbymanufacturer/{id}")
    public String getProductsByManufacturer(@PathVariable("id") Long id, Model model) {
        Manufacturer manufacturer = manufacturerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:" + id));
        List<Product> products = productRepository.findByManufacturer(manufacturer);
        model.addAttribute("products", products);
        model.addAttribute("manufacturer", manufacturer);
        return "productsbymanufacturer";
    }

    @RequestMapping("/homepage")
    public String homePage() {
        return "homepage";
    }

}
