package com.example.demo.Service;

import com.example.demo.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    Menu createMenu(Menu menu);
    List<Menu> getAllMenus();
    Optional<Menu> getMenuById(Long id);
    Menu updateMenu(Long id, Menu menuDetails);
    void deleteMenu(Long id);
}