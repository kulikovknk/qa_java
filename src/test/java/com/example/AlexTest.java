package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline feline;

    @Test
    public void testGetFriends() throws Exception {

        List<String> expectedResult = List.of("Марти", "Глория", "Мелман");

        Alex alex = new Alex(feline);
        Assert.assertEquals(expectedResult, alex.getFriends());

    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {

        String expectedResult = "Нью-Йоркский зоопарк";

        Alex alex = new Alex(feline);
        Assert.assertEquals(expectedResult, alex.getPlaceOfLiving());

    }

    @Test
    public void testGetKittens() throws Exception {

        int expectedResult = 0;

        Alex alex = new Alex(feline);
        Assert.assertEquals(expectedResult, alex.getKittens());

    }
}