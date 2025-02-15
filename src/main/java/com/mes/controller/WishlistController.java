package com.mes.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mes.model.DropdownItem;
import com.mes.model.NavLink;
import com.mes.model.Product;
import com.mes.model.User;
import com.mes.model.Wishlist;
import com.mes.repository.ProductsRepository;
import com.mes.repository.UserRepository;
import com.mes.repository.WishlistRepository;
import com.mes.service.CustomUserDetail;
import com.mes.service.NavBarService;
import com.mes.service.ProductService;
import com.mes.service.WishListService;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {
    @Autowired
    private WishListService wishlistService;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductsRepository productRepository;
    
    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private NavBarService service; 
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/view")
    public String viewWishlist(Model model, Authentication authentication) {
    	Map<NavLink, List<DropdownItem>> navbarWithDropdownData = service.getNavbarWithDropdownData();
    	model.addAttribute("navbarWithDropdownData", navbarWithDropdownData);
        if (authentication != null && authentication.isAuthenticated()) {
            CustomUserDetail userDetails = (CustomUserDetail) authentication.getPrincipal();
            User user = userDetails.getUser();
            List<Wishlist> wishlist = wishlistService.getWishlistByUser(user);
            model.addAttribute("wishlist", wishlist);
        }
        return "products/Wishlist";
    }



    @PostMapping("/add")
    public String addToWishlist(@RequestParam("productId") int productId, 
                                Authentication authentication,
                                RedirectAttributes redirectAttributes) {
        if (authentication != null && authentication.isAuthenticated()) {
            CustomUserDetail userDetails = (CustomUserDetail) authentication.getPrincipal();
            User user = userDetails.getUser();
            Product product = productService.getProductById(productId);

            // Check if the product is already in the wishlist
            if (!wishlistService.isProductInWishlist(user, product)) {
                wishlistService.addToWishlist(user, product);
                redirectAttributes.addFlashAttribute("message", "Product added to wishlist successfully.");
            } else {
                redirectAttributes.addFlashAttribute("message", "Product is already in the wishlist.");
            }
        }
        return "redirect:/wishlist/view";
    }
    
    @PostMapping("/remove")
    public String removeFromWishlist(@RequestParam("productId") int productId, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            CustomUserDetail userDetails = (CustomUserDetail) authentication.getPrincipal();
            User user = userDetails.getUser();
            Product product = productService.getProductById(productId);
            wishlistService.removeFromWishlist(user, product);
        }
        return "redirect:/wishlist/view";
    }
    
   
}
