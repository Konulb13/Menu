package org.example.restaurant_menu.service;

import org.example.restaurant_menu.model.Menu;
import org.example.restaurant_menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }
    public List<Menu> getMenuByPrice(double min_price, double max_price){
        return menuRepository.findMenuByPriceBetween(min_price,max_price);
    }
    public List<Menu>getMenuWithDiscount(){
        return menuRepository.findByDiscount(true);
    }
    public List<Menu>getMenuByMaxWeight(double max_weight){
        return menuRepository.findAll().stream()
                .filter(menu -> menu.getWeight()<= max_weight)
                .limit(1)    //1 kg
                .toList();
    }
}
