package shoppinglist.uiBoundary.MergeList;

import java.util.List;

import org.springframework.stereotype.Component;

import shoppinglist.lmerge.ListElement;

@Component
public interface IMergeList {
    public List<ListElement> merge(List<ListElement> list);
}
