package lmerge;

public class KnownVolumeUnits extends KnownUnits {
    public static final VolumeUnit ml = new VolumeUnit("ml", 0.001);
    public static final VolumeUnit cl = new VolumeUnit("cl", 0.1);
    public static final VolumeUnit l = new VolumeUnit("l", 1);
    
    KnownVolumeUnits() {
        unitMap.put("ml", ml);
        unitMap.put("cl", cl);
        unitMap.put("l", l);
    }
}
