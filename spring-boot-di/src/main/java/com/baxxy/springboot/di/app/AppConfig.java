package com.baxxy.springboot.di.app;


import java.util.ArrayList;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.baxxy.springboot.di.app.models.domains.ItemInvoice;
import com.baxxy.springboot.di.app.models.domains.Product;


@Configuration
public class AppConfig {
	


    @Bean("itemsInvoice")
    public List<ItemInvoice> registerItems() {
        Product p1 = new Product("Milanesa", 35);
        Product p2 = new Product("Gaseosa", 5);
        Product p3 = new Product("Merengón", 10);

        ItemInvoice line1 = new ItemInvoice(p1, 6);
        ItemInvoice line2 = new ItemInvoice(p2, 4);
        ItemInvoice line3 = new ItemInvoice(p3, 3);
        
        List<ItemInvoice> items = new ArrayList<>();
        items.add(line1);
        items.add(line2);
        items.add(line3);
        	
        
        
        return items;

    }
    
    
    @Bean("itemInvoiceOffice")
    @Primary
    public List<ItemInvoice> registerItemsOffice(){
    	Product p1 = new Product("Computador lenovo", 1250);
        Product p2 = new Product("Silla hergonomica", 340);
        Product p3 = new Product("Mouse Hp", 83);
        Product p4 = new Product("Mousepad kalley", 12);
        Product p5 = new Product("Keyword Hp", 70);
        
        ItemInvoice line1 = new ItemInvoice(p1, 10);
        ItemInvoice line2 = new ItemInvoice(p2, 5);
        ItemInvoice line3 = new ItemInvoice(p3, 10);
        ItemInvoice line4 = new ItemInvoice(p4, 6);
        ItemInvoice line5 = new ItemInvoice(p5, 10);
        
        
        List<ItemInvoice> items = new ArrayList<>();
        items.add(line1);
        items.add(line2);
        items.add(line3);
        items.add(line4);
        items.add(line5);
        	
        
        
        return items;
    }
 
}
