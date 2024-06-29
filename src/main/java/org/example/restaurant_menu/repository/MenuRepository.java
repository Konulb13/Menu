package org.example.restaurant_menu.repository;

import org.example.restaurant_menu.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findMenuByPriceBetween(double min_price, double max_price);
    List<Menu>findByDiscount(boolean discount);

}

