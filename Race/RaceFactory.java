package Race;

public class RaceFactory {

    public static CharacterRace getRace(RaceAbstractFactory factory){
        return factory.create();
    }
}
