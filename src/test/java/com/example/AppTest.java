
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testTwoWheelerFee() {
        assertEquals(10, App.calculateFee("two-wheeler", 1));
    }

    @Test
    public void testFourWheelerFee() {
        assertEquals(20, App.calculateFee("four-wheeler", 1));
    }

    @Test
    public void testOneHourParking() {
        assertEquals(10, App.calculateFee("two-wheeler", 1));
    }

    @Test
    public void testMultiHourParking() {
        assertEquals(60, App.calculateFee("two-wheeler", 6));
    }

    @Test
    public void testPartialHourRounding() {
        assertEquals(40, App.calculateFee("four-wheeler", 1.5));
    }

    @Test
    public void testBikeAlias() {
        assertEquals(30, App.calculateFee("bike", 3));
    }

    @Test
    public void testCarAlias() {
        assertEquals(40, App.calculateFee("car", 2));
    }

    @Test
    public void testZeroDuration() {
        assertThrows(IllegalArgumentException.class,
            () -> App.calculateFee("two-wheeler", 0));
    }

    @Test
    public void testNegativeDuration() {
        assertThrows(IllegalArgumentException.class,
            () -> App.calculateFee("four-wheeler", -2));
    }

    @Test
    public void testUnsupportedVehicle() {
        assertThrows(IllegalArgumentException.class,
            () -> App.calculateFee("bus", 2));
    }

    @Test
    public void testNullVehicle() {
        assertThrows(IllegalArgumentException.class,
            () -> App.calculateFee(null, 2));
    }

    @Test
    public void testInfiniteDuration() {
        assertThrows(IllegalArgumentException.class,
            () -> App.calculateFee("car", Double.POSITIVE_INFINITY));
    }
}
