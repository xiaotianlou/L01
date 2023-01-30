package pk;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Card {


    public boolean winner_check(Player p) {
        if (p.getScore() >= 6000) {
            MyLogger.log.info("player" + p.getName() + " get the " + p.getScore() + " with score " + p.getScore());
            return true;
        } else return false;
    }
    public int calculation(Player p){
        AtomicInteger score_change = new AtomicInteger(0);
        AtomicBoolean Full_chest_counter = new AtomicBoolean(true);
        if (p.store_temp.get(Faces.SKULL) >= 3) {
            MyLogger.log.info("Player " + p.getName()+ " get " + 0 + " in this term");
            MyLogger.log.info("Player " + p.getName() + " has the score " + p.getScore());
            return 0;
        }
        p.store_temp.entrySet().stream().forEach((entry) -> {//combine mark
            int value = entry.getValue();
            if (value >= 5) {
                score_change.addAndGet((int) (500 * Math.pow(2, value - 5)));
            } else if (value >= 3) {
                score_change.addAndGet(100 * (value - 2));
            }
        });
        score_change.addAndGet((p.store_temp.get(Faces.DIAMOND) + p.store_temp.get(Faces.GOLD)) * 100);//gold and dimond add
        if (p.store_temp.get(Faces.SKULL) == 0) {
            p.store_temp.forEach((key, value) -> {
                if (key != Faces.GOLD && key != Faces.DIAMOND && value > 0 & value < 3) {
                    Full_chest_counter.set(false);
                }
            });
        } else {
            Full_chest_counter.set(false);
        }
        if (Full_chest_counter.get()) {
            score_change.addAndGet(500);
        }

        p.add_score(score_change.get());
        return score_change.get();
    }

    public void score_cal(Player p) {
        p.refresh_map();
       int score_change =calculation(p);
        MyLogger.log.info("Player " + p.getName() + " get " + score_change + " in this term");
        MyLogger.log.info("Player " + p.getName() + " has the score " + p.getScore());
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
