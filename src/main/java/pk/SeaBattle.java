package pk;

public class SeaBattle extends Card {

    public boolean winner_check(Player p) {
        if (p.getScore() >= 6000+800) {
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
            p.sc

        } else {
            p.turn_act();
        }
    }
    public void end_turn_check(Player p) throws Exception {
        MyLogger.log.info("this is sea battle mode");
        MyLogger.log.info(p.getName() + " need get 3 SABER to win the sea battle and gain 1000 marks");
        MyLogger.log.info("if " + p.getName() + " lose the seabattle he will lose 800 marks and dice will ignore");

        p.print_dice_bag();

        trible_skull_check(p);




        if (winner_check(p)) {
            return;
        }




    }


}
