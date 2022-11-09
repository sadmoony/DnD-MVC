package Main;

public class Dice {
    protected int roll(){
        int cub = (int) (Math.random() * 6);

        return cub;
    }
}
