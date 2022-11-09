package Visitor;

import Main.Character;
import Main.Stats;
import Race.CharacterRace;
import classes.CharacterClass;

import java.util.TreeMap;

public interface DataElementsVisitor {
    public TreeMap visit(Character character);
    public TreeMap visit(CharacterClass characterClass);
    public TreeMap visit(CharacterRace characterRace);
    public TreeMap visit(Stats stats);
}
