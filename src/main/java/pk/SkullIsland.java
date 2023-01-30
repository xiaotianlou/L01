package pk;

public class SkullIsland extends Card{

    int skull_count_before;
    int skull_after;

    @Override
    public void end_turn_check(Player p) throws Exception {
        MyLogger.log.info("this Skull island");
        MyLogger.log.info(p.getName() + " player need get more skull as possible");
        p.refresh_map();
        if(skull_count_before==0) {
            skull_after = p.store_temp.get(Faces.SKULL);
        }
        p.print_dice_bag();
        if (winner_check(p)) {
            return;
        }
        trible_skull_check(p);
    }
    public void score_cal(Player p) {
        p.refresh_map();
        int score_change =100*p.store_temp.get(Faces.SKULL);

        for (Player other:p.getPlayer_list()){
            if (other.getName()!=p.getName()) {
                other.add_score(-1*score_change);
                MyLogger.log.info("Player " + other.getName() + " lose " + score_change + " by skull island in this term");
                MyLogger.log.info("Player " + other.getName() + " has the score " + other.getScore());
            }
        }

        MyLogger.log.info("Player " + p.getName() + " has the score " + p.getScore());

    }
    public void trible_skull_check(Player p) throws Exception {
        int difference = skull_after-skull_count_before;
        skull_count_before=skull_after;
        if(difference>0){
            p.turn_act();
        }else {
         MyLogger.log.trace("no more skull be roll, end the term, other player lose mark");
            p.end_turn();
            //别的玩家减分
        }
    }
}
