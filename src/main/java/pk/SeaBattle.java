package pk;

public class SeaBattle extends Card{
    public void end_turn_check(Player p) throws Exception {
        MyLogger.log.info("this is sea battle mode");
        p.print_dice_bag();
        int count = 0;
        if (p.getScore() >= 6000) {
            MyLogger.log.info("player" + p.getName() + " get the " + p.getScore() + " with score " + p.getScore());
            return;
        }
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



}
