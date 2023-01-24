package pk;

import java.util.Arrays;
import java.util.HashMap;

public class Ai_comb_mode implements AiStrategy {
    @Override
    public void turn_acting(Player p) throws Exception {
        boolean[] rolling_number = new boolean[8];
        for (int i = 0; i < rolling_number.length; i++) {
            rolling_number[i] = false;
        }
        p.soft_bag();
        p.refresh_map();
        HashMap<Faces, Integer> record = p.store_temp;
        int Score = p.getScore();
        if (record.get(Faces.SKULL) == 2) {
            p.end_turn();
        } else {
            for (Faces f : Faces.values()) {
                if (record.get(f) < 3 && f != Faces.SKULL) {
                    for (int i = 0; i < 8; i++) {
                        if (p.dice_bag[i].equals(f)) {
                            rolling_number[i] = true;
                        }
                    }
                }
            }

            MyLogger.log.trace("rolling" + Arrays.toString(rolling_number));
            p.re_roll(rolling_number);
        }
    }
}