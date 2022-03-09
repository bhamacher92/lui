package shoppinglist.lmerge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KnownWeightUnitsTests {
    @Test
    public void testAsWeightUnit() {
        UnitFactory unitFactory = new UnitFactory();
        assertEquals(unitFactory.createFromString("mg"), KnownWeightUnits.mg);
        assertEquals(unitFactory.createFromString("g"), KnownWeightUnits.g);
        assertEquals(unitFactory.createFromString("kg"), KnownWeightUnits.kg);
        assertEquals(unitFactory.createFromString("lbs"), KnownWeightUnits.lbs);
    }
}
