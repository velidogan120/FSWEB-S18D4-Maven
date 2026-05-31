package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerErrorException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void validateBurger(Burger burger) {

        if (burger == null) {
            throw new BurgerErrorException("Burger cannot be null", HttpStatus.NOT_FOUND);
        }
    }

    public static void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new BurgerErrorException("Invalid ID", HttpStatus.BAD_REQUEST);
        }
    }
}
