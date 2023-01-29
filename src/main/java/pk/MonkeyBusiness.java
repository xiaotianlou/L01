package pk;

public class MonkeyBusiness extends Card{


    public void score_cal(Player p) {
        p.refresh_map();
        p.store_temp.put(Faces.MONKEY,p.store_temp.get(Faces.MONKEY)+p.store_temp.get(Faces.PARROT));
        p.store_temp.put(Faces.PARROT,0);
        int score_change =calculation(p);
        MyLogger.log.info("Player " + p.getName() + " get " + score_change + " in this term");
        MyLogger.log.info("Player " + p.getName() + " has the score " + p.getScore());
    }



    @Override
    public void end_turn_check(Player p) throws Exception {
        MyLogger.log.info("this is monkey business");
        MyLogger.log.info(p.getName() + " player's monkey and parrot consider in same combo");
        p.print_dice_bag();
        if (winner_check(p)) {
            return;
        }
        trible_skull_check(p);



    }


}
