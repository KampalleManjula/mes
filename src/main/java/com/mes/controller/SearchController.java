package com.mes.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.model.Aboutus;
import com.mes.model.CarouselImage;
import com.mes.model.Consumerpolicy;
import com.mes.model.Customersupport;
import com.mes.model.DropdownItem;
import com.mes.model.Mailus;
import com.mes.model.MovingCards;
import com.mes.model.NavLink;
import com.mes.model.Popup;
import com.mes.model.Product;
import com.mes.model.Roaddress;
import com.mes.repository.AboutusRepository;
import com.mes.repository.ConsumerpolicyRepository;
import com.mes.repository.CustomersupportRepository;
import com.mes.repository.DownloadappsRepository;
import com.mes.repository.KeepintouchRepository;
import com.mes.repository.MailusRepository;
import com.mes.repository.MovingCardsRepository;
import com.mes.repository.PopupRepository;
import com.mes.repository.RoaddressRepository;
import com.mes.service.CardItemService;
import com.mes.service.CarouselImageService;
import com.mes.service.NavBarService;
import com.mes.service.ProductService;

@Controller
public class SearchController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private NavBarService navBarService;
    
    @Autowired
   	private CardItemService cardItemService;
   	
       @Autowired
   	private CarouselImageService carouselImageService;
    
    @Autowired
    private AboutusRepository aboutusRepository;

    @Autowired
    private ConsumerpolicyRepository consumerpolicyRepository;

    @Autowired
    private CustomersupportRepository customersupportRepository;
    
    @Autowired
    private DownloadappsRepository downloadappsRepository;

    @Autowired
    private KeepintouchRepository keepintouchRepository;
    
    @Autowired
    private MailusRepository mailusRepository;
    
    @Autowired
    private RoaddressRepository roaddressRepository;
    
    
    @Autowired
  		PopupRepository repo;
    
    
    @Autowired
   	private MovingCardsRepository cardrepo;
  	   

    
    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
    	
    	query=query.trim();
    	
        List<Product> products = productService.searchProducts(query);

        if(query.isEmpty()) {
        	
        	 List<NavLink> allNavLinks = navBarService.getAllNavLinks();
             Map<NavLink, List<DropdownItem>> navbarWithDropdownData = navBarService.getNavbarWithDropdownData();

             
             List<CarouselImage> images = carouselImageService.getAllImages();
     		model.addAttribute("images", images);
             List<Popup> image=repo.findAll();
           		model.addAttribute("image",image);

           		
           		
           		 List<MovingCards> card=cardrepo.findAll();
            		model.addAttribute("card",card);
            
             model.addAttribute("allNavLinks", allNavLinks);
             model.addAttribute("navbarWithDropdownData", navbarWithDropdownData);
             
           
             // Get data for the footer from the database
             List<Aboutus> aboutusList = aboutusRepository.findAll();
             List<Consumerpolicy> consumerpolicyList = consumerpolicyRepository.findAll();
             List<Customersupport> customersupportList = customersupportRepository.findAll();
             List<com.mes.model.Downloadapps> downloadappsList = downloadappsRepository.findAll();
             List<com.mes.model.Keepintouch> keepintouchList = keepintouchRepository.findAll();
             List<Mailus> mailusList = mailusRepository.findAll();
             List<Roaddress> roaddressList = roaddressRepository.findAll();

             // Add data to the model for footer
             model.addAttribute("aboutusList", aboutusList);
             model.addAttribute("consumerpolicyList", consumerpolicyList);
             model.addAttribute("customersupportList", customersupportList);
             model.addAttribute("downloadappsList", downloadappsList);
             model.addAttribute("keepintouchList", keepintouchList);
             model.addAttribute("mailusList", mailusList);
             model.addAttribute("roaddressList", roaddressList);

             // Add links to each record
             model.addAttribute("googleLink", "https://www.google.com");
             model.addAttribute("cardItems", cardItemService.getAllCardItems());
             // Return the HTML template name
             return "index";
        	
       }
       
        
        if (products.isEmpty()) {
            model.addAttribute("errorMessage", "No products found for the query: " + query);
            return "products/error";
        } else {
            model.addAttribute("products", products);
            return "products/UserProduct"; 
        }
    }
}