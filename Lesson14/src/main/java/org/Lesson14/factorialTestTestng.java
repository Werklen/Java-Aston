package org.Lesson14;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class factorialTestTestng {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.factorial(0), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(Factorial.factorial(5), 120); // 5! = 120
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(Factorial.factorial(1), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        Factorial.factorial(-1);
    }
}
