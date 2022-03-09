package shoppinglist.shared;

import java.util.ArrayList;
import java.util.Objects;

import shoppinglist.lmerge.*;

public class ShoppingList {
    public String name;
    public ArrayList<ListElement> elements;

    public ShoppingList() {
        name = new String();
        elements=new ArrayList<ListElement>();
    }

    public ShoppingList(String name){
        this.name = name;
        elements= new ArrayList<ListElement>();
    }

    public ShoppingList(ShoppingList other){
        this.name = other.name;
        this.elements=new ArrayList<ListElement>();
        for(ListElement ele : other.elements){
            this.elements.add(new ListElement(ele));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ShoppingList)) {
            return false;
        }
        ShoppingList shoppingList = (ShoppingList) o;
        return Objects.equals(name, shoppingList.name) && Objects.equals(elements, shoppingList.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, elements);
    }


}
