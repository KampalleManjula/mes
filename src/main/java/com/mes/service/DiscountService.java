package com.mes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.model.Discount;
import com.mes.repository.DiscountRepository;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    
    
    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public Discount getDiscountById(Long id) {
        Optional<Discount> discount = discountRepository.findById(id);
        return discount.orElse(null);
    }

    public void saveDiscount(Discount discount) {
        discountRepository.save(discount);
    }

    public void updateDiscount(Discount discount) {
        discountRepository.save(discount);
    }

    public void deleteDiscount(Long id) {
        discountRepository.deleteById(id);
    }
}