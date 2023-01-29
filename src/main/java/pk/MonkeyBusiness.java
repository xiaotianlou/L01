package pk;

public class MonkeyBusiness extends Card{
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
