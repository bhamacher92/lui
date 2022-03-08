package sconvert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lmerge.ListElement;
import lmerge.Quantity;

public class StringConverterTest {

    @Test
    public void testEntryWithoutUnit() {
        ListElement expected= new ListElement("Reis");
        String text = "Reis";
        ListElement result=StringConverter.string2ListElement(text);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testEntryWithQuantity(){
        ListElement expected= new ListElement("Eier", new Quantity(3));
        String text = "3 Eier";
        ListElement result=StringConverter.string2ListElement(text);
        assertTrue(result.equals(expected));
    }
    @Test 
    public void testEntryWithWeightUnits(){
        ListElement expected= new ListElement("Reis",new Quantity(3,"kg"));
        String text = "3 kg Reis";
        ListElement result=StringConverter.string2ListElement(text);
        assertTrue(result.equals(expected));
    }
    @Test
    public void testEntryWithVolumeUnits(){
        ListElement expected= new ListElement("Saure Sahne",new Quantity(20,"ml"));
        String text = "20 ml Saure Sahne";
        ListElement result=StringConverter.string2ListElement(text);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testEntryWithDoubleValue(){
        ListElement expected= new ListElement("Saure Sahne",new Quantity(20.2,"ml"));
        String text = "20.2 ml Saure Sahne";
        ListElement result=StringConverter.string2ListElement(text);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testListElement2String(){
        String expected="20 l Suesse Sahne";
        ListElement ele=new ListElement("Suesse Sahne", new Quantity(20,"l"));
        String result=StringConverter.listELement2String(ele);
        assertTrue(expected.equals(result));
        expected="20.2 l Süße Sahne";
        ele=new ListElement("Süße Sahne", new Quantity(20.2,"l"));
        result=StringConverter.listELement2String(ele);
        assertTrue(expected.equals(result));
    }




}
