package com.example.demo.service;

import com.example.demo.Entity.Menu;
import java.util.List;

public interface MenuService {
    Menu createMenu(Menu menu);
    Menu getMenuById(Long id);
    List<Menu> getAllMenus();
    Menu updateMenu(Long id, Menu menu);
    void deleteMenu(Long id);
}