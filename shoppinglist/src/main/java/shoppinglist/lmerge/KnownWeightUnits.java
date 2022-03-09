package shoppinglist.lmerge;

public class KnownWeightUnits extends KnownUnits{
    public static final WeightUnit mg = new WeightUnit("mg", 0.000001);
    public static final WeightUnit g = new WeightUnit("g", 0.001);
    public static final WeightUnit kg = new WeightUnit("kg", 1);
    public static final WeightUnit lbs = new WeightUnit("lbs", 0.453592);
    
    KnownWeightUnits() {
        unitMap.put("mg", mg);
        unitMap.put("g", g);
        unitMap.put("kg", kg);
        unitMap.put("lbs", lbs);
    }

}
