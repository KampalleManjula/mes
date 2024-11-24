package com.mes.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mes.model.Orders;
import com.mes.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderTrackingController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/trackOrder/{orderNumber}")
    public String trackOrder(@PathVariable("orderNumber") String orderNumber, Model model) {
        Orders order = orderService.getOrderByOrderNumber(orderNumber);
        if (order != null) {
            model.addAttribute("orders", order);
            return "orderTrackingPage";
        } else {
            return "errorPage";
        }
       
    }
}
