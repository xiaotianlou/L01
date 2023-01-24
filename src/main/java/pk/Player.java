package pk;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player {
    private final String name;



    Dice[] dice_bag = new Dice[8];
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        for (int i = 0; i < dice_bag.length; i++) {
            dice_bag[i] = new Dice();

        }
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    public void print_dice_bag() {
        String str="player " + name + " have dice: ";
        for (Dice i : dice_bag) {
           str= str.concat(i.face + " ");

        }
//       str= str.concat("---------------------");
        MyLogger.log.trace(str);
    }

    public void Init_round() throws Exception {
        //can move to cons
        end_turn_check();

    }

    public void restart() {
        score = 0;
    }
    public void turn_act() throws Exception {
        System.out.println("player inter");
    }

    public void score_cal() {
        for (Dice d : dice_bag) {
            if (d.face == Faces.DIAMOND || d.face == Faces.GOLD)
                this.score += 100;
        }
        MyLogger.log.trace("Player " + name + " has the score " + score);
    }

    public void end_turn_check() throws Exception {
        print_dice_bag();
        int count = 0;
        if (score >= 6000) {
            MyLogger.log.trace("player" + name + " get the 6000 with score " + score);

            return;
        }

        for (Dice d : dice_bag) {
            if (d.face == Faces.SKULL) {
                count++;
            }
        }
        System.out.println("count="+count);
        if (count >= 3) {
            MyLogger.log.trace("------------------End The Term-------------------");
            score_cal();
        } else {
            turn_act();
        }
    }

    public void re_roll(boolean[] index) throws Exception {
        int valid_count = 0;
        for (int i = 0; i < 8; i++) {
            if (index[i] && dice_bag[i].face != Faces.SKULL) valid_count++;
        }
        if (valid_count >= 2) {
            for (int i = 0; i < 8; i++) {

                if (index[i]) {
                    dice_bag[i].roll();
                }
            }

            end_turn_check();
        } else {
            MyLogger.log.warn("not success reroll at least 2 valid,doing again");
//            System.out.println("not success reroll at least 2 valid,doing again");

            end_turn_check();
        }

    }

}
