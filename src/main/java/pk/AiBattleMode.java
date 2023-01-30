package pk;

import java.util.Arrays;
import java.util.HashMap;

public class AiBattleMode implements AiStrategy {
    @Override
    public void turn_acting(Player p) throws Exception {
        boolean[] rolling_number = new boolean[8];
        p.soft_bag();
        p.refresh_map();
        HashMap<Faces, Integer> record = p.store_temp;

        if (record.get(Faces.SABER) >= 3) {
            MyLogger.log.trace("ending term by player" + p.getName());
            p.end_turn();
            return;
        } else {
            //As long as it is not a military knife are roll
            int counter = 0;
            Faces temp;
            for (int i = 0; i < 8; i++) {
                temp = p.dice_bag[i].face;
                if (!temp.equals(Faces.SABER) && !temp.equals(Faces.SKULL)) {
                    rolling_number[i] = true;
                    counter++;
                }
            }
            if (counter < 2) {
                MyLogger.log.trace("ending term by player" + p.getName());
                p.end_turn();
                return;
            }//冗余
        }
//        System.out.println("counter="+counter);
        MyLogger.log.trace("rolling" + Arrays.toString(rolling_number));
        p.re_roll(rolling_number);
    }
}
