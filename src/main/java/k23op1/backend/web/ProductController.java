package k23op1.backend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import ch.qos.logback.core.model.Model;
import k23op1.backend.domain.Product;
import k23op1.backend.domain.ProductRepository;


@Controller
public class ProductController {
   
    
    @Autowired
    private ProductRepository productRepository;

// Tuotelistaus
@RequestMapping( value= "/productlist", method = RequestMethod.GET)
public ModelAndView productList() {
    List<Product> products = (List<Product>) productRepository.findAll();
    ModelAndView modelAndView = new ModelAndView("productlist");
    modelAndView.addObject("products", products);
    return modelAndView;
}
  
  
  

@RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
public String deleteProduct(@PathVariable("productId") Long productId) {
    productRepository.deleteById(productId);
    return "redirect:/productlist";
}




// ModelAndView modelAndView = new ModelAndView("productlist");
    //modelAndView.addObject("products", products);
    //return modelAndView;
   
   

}
   
       
		



        //model.addAttribute("m", categoryRepository.findAll());
		