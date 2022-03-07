package lmerge;

import java.util.ArrayList;
import java.util.List;

public class Merger {

    public String getName(String input) {
        return input;
    }

    public List<ListElement> mergeList(List<ListElement> input) {
        List<ListElement> mergedList = new ArrayList<ListElement>();

        for (ListElement element : input) {
            List<Integer> indexList = getIndexOfMultiple(mergedList, element);

            boolean succeded = false;
            for (int i : indexList) {

                try {
                    mergedList.get(i).addQuantity(element.Quantity);
                    succeded = true;
                } catch (IllegalArgumentException e) {
                    // Not needed here
                }
            }

            if (!succeded)
                mergedList.add(new ListElement(element));
        }

        return mergedList;
    }

    private List<Integer> getIndexOfMultiple(List<ListElement> list, ListElement xElement) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i< list.size(); ++i) {
            if (list.get(i).equals(xElement))
                result.add(i);
        }
        return result;
    }
}
