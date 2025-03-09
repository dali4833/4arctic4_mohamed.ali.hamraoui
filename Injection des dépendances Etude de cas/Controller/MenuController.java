package com.example.demo.Controller;

import com.example.demo.Entity.Menu;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // Create a new menu
    @PostMapping
    public Menu createMenu(@RequestBody Menu menu) {
        return menuService.createMenu(menu);
    }

    // Get a menu by ID
    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long id) {
        Menu menu = menuService.getMenuById(id);
        if (menu != null) {
            return ResponseEntity.ok(menu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all menus
    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    // Update a menu by ID
    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @RequestBody Menu menuDetails) {
        Menu updatedMenu = menuService.updateMenu(id, menuDetails);
        if (updatedMenu != null) {
            return ResponseEntity.ok(updatedMenu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a menu by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }
}