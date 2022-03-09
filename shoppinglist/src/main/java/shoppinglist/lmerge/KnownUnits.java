package shoppinglist.lmerge;

import java.util.HashMap;
import java.util.Map;

public class KnownUnits {

    protected Map<String, Unit> unitMap = new HashMap<>();

    public Unit asUnit(String xUnit) {
        if (!unitMap.containsKey(xUnit))
            return new Unit(xUnit);

        return unitMap.get(xUnit);
    }

    public boolean contains(String key) {
        return unitMap.containsKey(key);
    }

    public Map<String, Unit> getUnitMap() {
        Map<String, Unit> copy = new HashMap<>();
        copy.putAll(unitMap);
        return copy;
    }
}
