package lmerge;

public class Unit implements Cloneable {
    public String Name = "";
    public double Ratio = 1;

    public static String UNKNOWN_TYPE = "Unknown";

    protected String Type = UNKNOWN_TYPE;

    Unit() {
        this.Type = "None";
    }

    Unit(String name, double ratio) {
        this.Name = name;
        this.Ratio = ratio;
    }

    Unit(String name) {
        this.Name = name;
    }

    Unit(Unit other) {
        this.Name = other.Name;
        this.Ratio = other.Ratio;
        this.Type = other.Type;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Unit)) 
            return false;
        
        if (this.Name.equals(((Unit)other).Name) && Double.compare(this.Ratio, ((Unit)other).Ratio) == 0)
            return true;

        return false;
    }

    public String getType() {
        return this.Type;
    }
}
