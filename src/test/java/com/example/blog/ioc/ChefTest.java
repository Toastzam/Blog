package com.example.blog.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ChefTest {
    @Autowired
    IngredientFactory ingredientFactory; // IoC 컨테니어임
    @Autowired
    Chef chef;
    @Test
    void  돈가스요리() {
        //준비
//        IngredientFactory ingredientFactory = new IngredientFactory();
//        Chef chef = new Chef(ingredientFactory);
        String menu = "돈가스";
        // tngod
        String food = chef.cook(menu);
        // 예상
        String expected = "한돈등심으로 만든돈가스";
        // 검증
        assertEquals(expected,food);
        System.out.println(food);
    }
    @Test
    void 스테이크요리() {
        //준비
//        IngredientFactory ingredientFactory = new IngredientFactory();
//        Chef chef = new Chef(ingredientFactory);
        String menu = "스테이크";
        // tngod
        String food = chef.cook(menu);
        // 예상
        String expected = "한우꽃등심으로 만든스테이크";
        // 검증
        assertEquals(expected,food);
        System.out.println(food);
    }
    @Test
    void 크리스피_치킨요리() {
//        IngredientFactory ingredientFactory = new IngredientFactory();
//        Chef chef = new Chef(ingredientFactory);
        String menu = "크리스피치킨";
        // tngod
        String food = chef.cook(menu);
        // 예상
        String expected = "국내산 10호 닭으로 만든크리스피치킨";
        // 검증
        assertEquals(expected,food);
        System.out.println(food);
    }
}