package pk;

import java.util.Random;

public class Ai_rand_mode implements AiStrategy {
    static  Random rad = new Random();
    @Override
    public void turn_acting(Player p) {
        int keep = rad.nextInt(8);

    }
}
