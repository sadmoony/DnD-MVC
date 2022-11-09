package classes;

public class ClassFactory {
    public static CharacterClass getClass(String type){
        if("classes.Barbarian".equalsIgnoreCase(type))
            return new Barbarian();
        else if ("classes.Paladin".equalsIgnoreCase(type))
            return new Paladin();

        return null;
    }
}
