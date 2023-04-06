package k23op1.backend.web;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

import k23op1.backend.domain.ManufacturerRepository;
import k23op1.backend.domain.Product;
import k23op1.backend.domain.ProductRepository;

@CrossOrigin
@Controller
public class ProductController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private ProductRepository productRepository;

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
    public String addProduct(Product product) {
        productRepository.save(product);
        return "redirect:/productlist";
    }

    @RequestMapping(value = "edit/{id}")
    public String editProduct(@PathVariable("id") Long productId, Model model) {
        System.out.println("controller" + productId);
        model.addAttribute("product", (productRepository.findById(productId)).get());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "editproduct";
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
}