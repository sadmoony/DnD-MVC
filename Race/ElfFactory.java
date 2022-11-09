package Race;

import Main.Stats;

public class ElfFactory implements RaceAbstractFactory{

    @Override
    public Elf create(){
        return new Elf(new Stats(0, 0, 0, 0, 0, 0));
    }
}
