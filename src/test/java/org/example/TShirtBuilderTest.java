package org.example;

import junit.framework.TestCase;
import org.example.controllers.builders.TShirtBuilder;
import org.example.models.clothing.TShirt;

public class TShirtBuilderTest extends TestCase {

    private TShirtBuilder builder;

    public void setUp() {
        builder = new TShirtBuilder();
    }

    public void testBuildValidTShirt() {
        TShirt tshirt = builder
                .addMaterial("Cotton")
                .addSize("Medium")
                .addColor("White")
                .build();

        assertNotNull(tshirt);
        assertEquals("Cotton", tshirt.getMaterial());
        assertEquals("Medium", tshirt.getSize());
        assertEquals("White", tshirt.getColor());
        assertEquals("V-neck", tshirt.getNeck());
        assertEquals("Long", tshirt.getSleeves());
    }

    public void testBuildThrowsExceptionWhenMissingFields() {
        builder.addMaterial("Cotton");
        builder.addSize("Medium");
        // Color is missing → should throw an exception
        try {
            builder.build();
            fail("Expected RuntimeException but none was thrown.");
        } catch (RuntimeException e) {
            // Expected exception
        }
    }

    public void testInvalidMaterialThrowsException() {
        try {
            builder.addMaterial("Silk");
            fail("Expected IllegalArgumentException but none was thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    public void testInvalidSizeThrowsException() {
        try {
            builder.addSize("XL");
            fail("Expected IllegalArgumentException but none was thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    public void testInvalidColorThrowsException() {
        try {
            builder.addColor("Blue");
            fail("Expected IllegalArgumentException but none was thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }
}