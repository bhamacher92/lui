package shoppinglist.lmerge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QuantityTests {

    @Test
    public void testIntAdd() {
        Quantity quantity1 = new Quantity(2);
        Quantity quantityToAdd = new Quantity(1);
        Quantity expectedQuantity = new Quantity(3);

        assertEquals(quantity1.add(quantityToAdd), expectedQuantity);
    }

    @Test
    public void testIntAddWithUnits() {
        Quantity quantity1 = new Quantity(2, "Priese");
        Quantity quantityToAdd1 = new Quantity(1, "Priese");
        Quantity quantityToAdd2 = new Quantity(1, "Dose");
        
        Quantity expectedQuantity = new Quantity(3, "Priese");

        assertEquals(quantity1.add(quantityToAdd1), expectedQuantity);
        
        boolean addingNonMatchingTypesThrows = false;
        try {
            quantity1.add(quantityToAdd2);
        }
        catch (Quantity.NonMatchingUnitException e) {
            addingNonMatchingTypesThrows = true;
        }
        catch (Exception e) {
            
        }
        assertTrue(addingNonMatchingTypesThrows);
    }

    @Test
    public void testGPlusKG() {
        Quantity quantity1 = new Quantity(1, "kg");
        Quantity quantity2 = new Quantity(1000, "g");

        Quantity expectedResult = new Quantity(2, "kg");

        assertEquals(Quantity.add(quantity1, quantity2), expectedResult);
        assertEquals(quantity1.add(quantity2), expectedResult);
    }

    @Test
    public void testWeightAdd() {
        KnownUnits weightUnits = new KnownWeightUnits();
        for (Unit unit : weightUnits.getUnitMap().values()) {
            Quantity quantity1 = new Quantity(10, unit);

            for (Unit subUnit : weightUnits.getUnitMap().values()) {
                Quantity quantity2 = new Quantity(10, subUnit);

                Quantity result =  Quantity.add(quantity1, quantity2);
                
                double si1 = quantity1.mUnit.Ratio * quantity1.Value;
                double si2 = quantity2.mUnit.Ratio * quantity2.Value;
                
                assertEquals(si1+si2, result.Value * result.mUnit.Ratio, 0.00001);
            }
        }
    }

    @Test
    public void testmlPlusl() {
        Quantity quantity1 = new Quantity(1000, "ml");
        Quantity quantity2 = new Quantity(1, "l");

        Quantity expectedResult = new Quantity(2, "l");

        assertEquals(Quantity.add(quantity1, quantity2), expectedResult);
        assertEquals(quantity1.add(quantity2), expectedResult);
    }

    @Test
    public void testVolumeAdd() {
        KnownUnits volumeUnits = new KnownVolumeUnits();
        for (Unit unit : volumeUnits.getUnitMap().values()) {
            Quantity quantity1 = new Quantity(10, unit);

            for (Unit subUnit : volumeUnits.getUnitMap().values()) {
                Quantity quantity2 = new Quantity(10, subUnit);

                Quantity result =  Quantity.add(quantity1, quantity2);
                
                double si1 = quantity1.mUnit.Ratio * quantity1.Value;
                double si2 = quantity2.mUnit.Ratio * quantity2.Value;
                
                assertEquals(si1+si2, result.Value * result.mUnit.Ratio, 0.00001);
            }
        }
    }

    @Test
    public void testEquals() {
        Quantity quantity1 = new Quantity(2, "kg");
        Quantity quantity2 = new Quantity(2, "kg");
        Quantity quantity3 = new Quantity(3, "kg");
        Quantity quantity4 = new Quantity(2, "mg");

        assertTrue(quantity1.equals(quantity2));
        assertFalse(quantity1.equals(quantity3));
        assertFalse(quantity1.equals(quantity4));
        assertFalse(quantity3.equals(quantity4));
    }
}
