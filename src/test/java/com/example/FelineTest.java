package com.example;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FelineTest {

    @Test
    public void testGetFamily() {

        String expectedResult = "Кошачьи";

        Feline feline = new Feline();
        Assert.assertEquals(expectedResult, feline.getFamily());

    }

    @Test
    public void testGetKittens() {

        int expectedResult = 1;

        Feline feline = new Feline();

        Assert.assertEquals(expectedResult, feline.getKittens());

    }

    @Test
    public void testEatMeat() throws Exception {

        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");

        Feline feline = new Feline();

        Assert.assertEquals(expectedResult, feline.eatMeat());

    }
}
