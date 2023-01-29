package pk;

public class NopeCard extends Card{
    public void end_turn_check(Player p) throws Exception {

        MyLogger.log.info("this is NopeCard");
        MyLogger.log.info(p.getName() + " need try it's best to get the mark");


        p.print_dice_bag();
        if (winner_check(p)) {
            return;
        }

        trible_skull_check(p);


    }
}
