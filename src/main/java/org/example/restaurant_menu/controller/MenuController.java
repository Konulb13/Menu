package org.example.restaurant_menu.controller;

import org.example.restaurant_menu.model.Menu;
import org.example.restaurant_menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    public MenuService menuService;

    @GetMapping("/new")
    public String showAddMenu(Model model){
        model.addAttribute("menus", new Menu());
        return "add-menu";
    }



    @PostMapping("/add")
    public String addMenu(@ModelAttribute Menu menu){
        menuService.saveMenu(menu);
        return "redirect:/menu/list";
    }

    @GetMapping("/list")
    public String showMenuList(Model model){
        model.addAttribute("menus",menuService.getAllMenus());
        return "menu-list";
    }

    @GetMapping("/price")
    public String showMenuByPrice(@RequestParam double min_price, @RequestParam double max_price, Model model) {
        model.addAttribute("menus", menuService.getMenuByPrice(min_price, max_price));
        return "menu-list";
    }

    @GetMapping("/discount")
    public String showMenuWithDiscount(Model model) {
        model.addAttribute("menus", menuService.getMenuWithDiscount());
        return "menu-list";
    }
    @GetMapping("/weight")
    public String showMenuByMaxWeight(@RequestParam double max_weight, Model model) {
        model.addAttribute("menus", menuService.getMenuByMaxWeight(max_weight));
        return "menu-list";
    }
    @GetMapping("/")
    public String index() {
        return "index";
    }

}
