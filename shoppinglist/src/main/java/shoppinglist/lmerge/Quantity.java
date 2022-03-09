package shoppinglist.lmerge;

public class Quantity {
	public double Value = 0 ;
    public Unit mUnit = new Unit();
    
    public Quantity(double value) {
        this.Value = value;
    }

    public Quantity(double value, Unit unit) {
        this.Value = value;
        this.mUnit = new Unit(unit);
    }

    public Quantity(double value, String unit) {
        this.Value = value;
        UnitFactory unitFactory = new UnitFactory();
        this.mUnit = unitFactory.createFromString(unit);
    }

    public Quantity(Quantity quantity) {
        this.Value = quantity.Value;
        this.mUnit = new Unit(quantity.mUnit);
    }

    public static Quantity add(Quantity quantity1, Quantity quantity2) {
        if (quantity1.mUnit.getType().equals(Unit.UNKNOWN_TYPE) || quantity2.mUnit.getType().equals(Unit.UNKNOWN_TYPE))
            if (!quantity1.mUnit.Name.equals(quantity2.mUnit.Name))
                throw new NonMatchingUnitException("Tried to add Unknown Quantities!");

        if (quantity2.mUnit.getType() != quantity1.mUnit.getType())
            throw new NonMatchingUnitException("Tried to add non matching Quantities!");

        double si1 = quantity1.mUnit.Ratio * quantity1.Value;
        double si2 = quantity2.mUnit.Ratio * quantity2.Value;

        if ( quantity1.mUnit.Ratio > quantity2.mUnit.Ratio) {
            return new Quantity((si1+si2)/quantity1.mUnit.Ratio , quantity1.mUnit);
        }

        return new Quantity((si1+si2)/quantity2.mUnit.Ratio , quantity2.mUnit);
    }

    public Quantity add(Quantity other) {
        if (this.mUnit.getType().equals(Unit.UNKNOWN_TYPE) || other.mUnit.getType().equals(Unit.UNKNOWN_TYPE))
            if (!this.mUnit.Name.equals(other.mUnit.Name))
                throw new NonMatchingUnitException("Tried to add Unknown Quantities!");

        if (other.mUnit.getType() != this.mUnit.getType())
            throw new NonMatchingUnitException("Tried to add non matching Quantities!");
        
        double si1 = this.mUnit.Ratio * this.Value;
        double si2 = other.mUnit.Ratio * other.Value;

        if ( this.mUnit.Ratio < other.mUnit.Ratio) {
            this.mUnit = new Unit(other.mUnit);
        }

        this.Value = (si1+si2)/this.mUnit.Ratio;
        return this;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Quantity)) 
            return false;
        
        if (this.mUnit.equals(((Quantity)other).mUnit) && Double.compare(this.Value, ((Quantity)other).Value) == 0)
            return true;

        return false;
    }

    public static class NonMatchingUnitException extends IllegalArgumentException {
        public NonMatchingUnitException(String s) {
            super(s);
        }
    }
}
