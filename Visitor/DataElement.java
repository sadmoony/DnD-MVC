package Visitor;

import java.util.TreeMap;

public interface DataElement {

    public TreeMap accept(DataElementsVisitor visitor);
}
