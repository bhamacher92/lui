package lmerge;

public class ListElement {
    public String Name;
    public Quantity Quantity;

    public ListElement(String name) {
        this.Name = name;
        this.Quantity = new Quantity(1);
    }

    public ListElement(String name, Quantity quantity) {
        this.Name = name;
        this.Quantity = new Quantity(quantity);
    }

    public ListElement(ListElement other) {
        this.Name = other.Name;
        this.Quantity = new Quantity(other.Quantity);
    }

    public ListElement addQuantity(Quantity quantity) {
        this.Quantity.add(quantity);
        return this;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ListElement)) 
            return false;
        
        if (this.Name.equals(((ListElement)other).Name))
            return true;

        return false;
    }

}
