package pk;

import java.util.ArrayList;

public abstract class Card {


    public boolean winner_check(Player p) {
        if (p.getScore() >= 6000) {
            MyLogger.log.info("player" + p.getName() + " get the " + p.getScore() + " with score " + p.getScore());
            return true;
        } else return false;
    }

    public void trible_skull_check(Player p) throws Exception {
        int count = 0;
        for (Dice d : p.dice_bag) {
            if (d.face == Faces.SKULL) {
                count++;
            }
        }
        MyLogger.log.trace("skull count=" + count);
        if (count >= 3) {
            p.end_turn();

        } else {
            p.turn_act();
        }
    }
    public abstract void end_turn_check(Player p) throws Exception;
}
