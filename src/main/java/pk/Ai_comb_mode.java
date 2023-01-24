package pk;

import java.util.Arrays;
import java.util.HashMap;

public class Ai_comb_mode implements AiStrategy {
    @Override
    public void turn_acting(Player p) throws Exception {
        boolean[] temp = new boolean[8];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = false;
        }
        p.soft_bag();
        p.score_cal();
        HashMap<Faces,Integer> record=p.store_temp;


        int Score=p.getScore();



        MyLogger.log.trace("rolling"+ Arrays.toString(temp));
        p.re_roll(temp);
    }
}
