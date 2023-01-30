package pk;

public class SeaBattle extends Card {


    public void trible_skull_check(Player p) throws Exception {
        int count = 0;
        for (Dice d : p.dice_bag) {
            if (d.face == Faces.SKULL) {
                count++;
            }
        }
        MyLogger.log.trace("skull count=" + count);
        if (count >= 3) {
            p.refresh_map();
            p.seaBattle_Cal();

        } else {
            p.turn_act();
        }
    }

    public void score_cal(Player p) {
        if (p.sea_battle_state()) {
            MyLogger.log.trace(p.getName() + " win the sea battle!");
            super.score_cal(p);
            MyLogger.log.trace(p.getName() + " get 800 by win the sea battle");
            p.add_score(800);
            MyLogger.log.info("player " + p.getName() + " Current score: " + p.getScore());
        } else {
            MyLogger.log.trace(p.getName() + " lose 800 by lose the sea battle,and end the term");
            p.add_score(-800);
            MyLogger.log.info("------------------End The " + p.getName() + " Term-------------------");
            MyLogger.log.info("player " + p.getName() + " Current score: " + p.getScore());
        }
    }


    public void end_turn_check(Player p) throws Exception {
        MyLogger.log.info("this is sea battle mode");
        MyLogger.log.info(p.getName() + " need get 3 SABER to win the sea battle and gain 800 marks");
        MyLogger.log.info("if " + p.getName() + " lose the seabattle he will lose 800 marks and dice will ignore");

        p.print_dice_bag();
        trible_skull_check(p);
        winner_check(p);
    }


}
