package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.util.BurgerValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/workintech/burgers")
public class BurgerController {

    private final BurgerDao burgerDao;

    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> getAll() {
        log.info("GET all burgers called");
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger getById(@PathVariable Long id) {

        BurgerValidation.validateId(id);

        log.info("GET burger by id: {}", id);
        return burgerDao.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Burger burger) {

        BurgerValidation.validateBurger(burger);

        log.info("POST new burger: {}", burger.getName());
        burgerDao.save(burger);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Burger burger) {

        BurgerValidation.validateId(id);
        BurgerValidation.validateBurger(burger);

        burger.setId(id);

        log.info("UPDATE burger id: {}", id);
        burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        BurgerValidation.validateId(id);

        log.info("DELETE burger id: {}", id);
        burgerDao.remove(id);
    }

    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(@RequestBody Integer price) {

        log.info("Find by price: {}", price);
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/findByBreadType")
    public List<Burger> findByBreadType(@RequestBody BreadType breadType) {

        log.info("Find by breadType: {}", breadType);
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/findByContent")
    public List<Burger> findByContent(@RequestBody String content) {

        log.info("Find by content: {}", content);
        return burgerDao.findByContent(content);
    }
}