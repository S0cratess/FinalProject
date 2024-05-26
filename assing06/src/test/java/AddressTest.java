package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    void testValidPostalCodes() {
        Assertions.assertTrue(Address.isPostalCodeValid("A1B2C3"));
        Assertions.assertTrue(Address.isPostalCodeValid("A1B 2C3"));
        Assertions.assertTrue(Address.isPostalCodeValid("A1B2C3"));
        Assertions.assertTrue(Address.isPostalCodeValid("A1B 2C3"));
        Assertions.assertTrue(Address.isPostalCodeValid("X1Y2Z3"));
        Assertions.assertTrue(Address.isPostalCodeValid("X1Y 2Z3"));
    }

    @Test
    void testInvalidPostalCodes() {
        Assertions.assertFalse(Address.isPostalCodeValid(null));
        Assertions.assertFalse(Address.isPostalCodeValid(""));
        Assertions.assertFalse(Address.isPostalCodeValid("AB"));
        Assertions.assertFalse(Address.isPostalCodeValid("A1B2C3D"));
        Assertions.assertFalse(Address.isPostalCodeValid("A1 B2C3"));
        Assertions.assertFalse(Address.isPostalCodeValid("A1B2C"));
        Assertions.assertFalse(Address.isPostalCodeValid("123456"));
        Assertions.assertFalse(Address.isPostalCodeValid("A!B2C3"));
    }
}
