package shoppinglist.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shoppinglist.lmerge.ListElement;
import shoppinglist.lmerge.Merger;
import shoppinglist.uiBoundary.MergeList.IMergeList;

@Component
public class UseListMerge implements IMergeList {
    
    @Autowired
    private Merger merger;

    public List<ListElement> merge(List<ListElement> list){
        return merger.mergeList(list);
    }

}
