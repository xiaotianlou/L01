package pk;

public class SeaBattle extends Card {


    public void end_turn_check(Player p) throws Exception {
        MyLogger.log.info("this is sea battle mode");
        MyLogger.log.info(p.getName() + " need get 3 SABER to win the sea battle and gain 1000 marks");
        MyLogger.log.info("if " + p.getName() + " lose the seabattle he will lose 800 marks and dice will ignore");

        p.print_dice_bag();
        if (winner_check(p)) {
            return;
        }
        trible_skull_check(p);
    }


}
