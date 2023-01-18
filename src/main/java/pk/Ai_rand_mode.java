package pk;

import java.util.Arrays;
import java.util.Random;

public class Ai_rand_mode implements AiStrategy {
    static  Random rad = new Random();
    @Override
    public  void turn_acting(Player p) throws Exception {
        boolean temp[]=new boolean[8];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=rad.nextBoolean();
        }
        System.out.println("rolling                         "+ Arrays.toString(temp));
        p.re_roll(temp);

    }
}
