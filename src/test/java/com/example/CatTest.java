package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void testGetSound(){

        String expectedResult = "Мяу";

        Cat cat = new Cat(feline);

        Assert.assertEquals(expectedResult, cat.getSound());

    }

    @Test
    public void testGetFood() throws Exception {

        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(feline.eatMeat()).thenReturn(expectedResult);

        Cat cat = new Cat(feline);

        Assert.assertEquals(expectedResult, cat.getFood());

    }


}
