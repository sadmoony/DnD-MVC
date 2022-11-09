package classes;

import Visitor.DataElement;
import Visitor.DataElementsVisitor;

import java.util.TreeMap;

public abstract class CharacterClass implements DataElement {

    protected String name;
    protected int dice;

    public int getDice() {
        return dice;
    }

    @Override
    public String toString() {
        return "Class: " + name + " (uses " + dice + "D dice to roll hp)";
    }

    public abstract void printMagika();

    @Override
    public TreeMap accept(DataElementsVisitor visitor){
        return visitor.visit(this);
    }
}
