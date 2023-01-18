package pk;

import java.util.Random;

public class Ai_rand_mode implements AiStrategy {
    static  Random rad = new Random();
    @Override
    public  void turn_acting(Player p) {
        boolean temp[]=new boolean[8];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=rad.nextBoolean();
        }
        p.re_roll(temp);

    }
}
