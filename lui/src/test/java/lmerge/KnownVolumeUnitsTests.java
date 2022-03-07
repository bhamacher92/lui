package lmerge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KnownVolumeUnitsTests {

    @Test
    public void testAsWeightUnit() {
        UnitFactory unitFactory = new UnitFactory();
        assertEquals(unitFactory.createFromString("ml"), KnownVolumeUnits.ml);
        assertEquals(unitFactory.createFromString("cl"), KnownVolumeUnits.cl);
        assertEquals(unitFactory.createFromString("l"), KnownVolumeUnits.l);
    }
}
