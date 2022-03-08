package lmerge;

import java.util.ArrayList;
import java.util.List;

public class UnitFactory {

    private List<KnownUnits> knownUnits = new ArrayList<KnownUnits>();

    public UnitFactory() {
        knownUnits.add(new KnownWeightUnits());
        knownUnits.add(new KnownVolumeUnits());
    }

    public Unit createFromString(String unit) {
        for (KnownUnits knownUnit : knownUnits ) {
            if (knownUnit.contains(unit))
                return knownUnit.asUnit(unit);
        }

        return new Unit(unit);
    }
}
