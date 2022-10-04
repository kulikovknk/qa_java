package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    @Parameterized.Parameters(name = "{index}: {0} (hasMane - {1})")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true },
                { "Самка", false } });
    }

    @Parameterized.Parameter(0)
    public String sex;

    @Parameterized.Parameter(1)
    public boolean hasMane;

    @Mock
    private Feline feline;

    @Before
    public void SetUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetKittens() throws Exception {

        int expectedResult = 1;

        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(expectedResult);

        Assert.assertEquals(expectedResult, lion.getKittens());

    }

    @Test
    public void testDoesHaveMane() throws Exception {

        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(hasMane, lion.doesHaveMane());

    }

    @Test
    public void testGetFood() throws Exception {

        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");

        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedResult);

        Assert.assertEquals(expectedResult, lion.getFood());

    }

    @Test
    public void testThrowException() {

        String invalidSexValue = "qwerty";
        String expectedExceptionMessage = "Используйте допустимые значения пола животного - самей или самка";

        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion(invalidSexValue, feline);
        });

        Assert.assertEquals(expectedExceptionMessage, exception.getMessage());

    }
}
