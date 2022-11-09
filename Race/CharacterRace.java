package Race;

import Main.Stats;
import Visitor.DataElement;
import Visitor.DataElementsVisitor;

import java.util.TreeMap;

public abstract class CharacterRace implements DataElement {

    protected String name;
    protected Stats bonuses;

    public abstract int getRaceBonuses(String type);

    public abstract void battleCry();

    @Override
    public TreeMap accept(DataElementsVisitor visitor){
        return visitor.visit(this);
    }
}
