package pk;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

public class Ai_rand_mode implements AiStrategy {
    static Random rad = new Random();
    static Logger log = LogManager.getLogger(logtest.class);


    @Override
    public void turn_acting(Player p) throws Exception {
        boolean[] temp = new boolean[8];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = rad.nextBoolean();
        }
        log.trace("rolling                         "+ Arrays.toString(temp));
//        System.out.println("rolling                         "+ Arrays.toString(temp));
        p.re_roll(temp);

    }
}
