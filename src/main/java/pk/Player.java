package pk;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Player {
    private final String name;
    HashMap<Faces, Integer> store_temp = new HashMap<>();
    Dice[] dice_bag = new Dice[8];
    Card card;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        for (int i = 0; i < dice_bag.length; i++) {
            dice_bag[i] = new Dice();
        }
    }

    public void add_score(int val) {
        score += val;
    }

    public int getScore() {
        return this.score;
    }

    public void seaBattle_Cal() {
        if (sea_battle_state()) {
            MyLogger.log.trace(name + " win the sea battle!");
            card.score_cal(this);
            MyLogger.log.trace(name + " get 800 by win the sea battle");
            this.score += 800;
            MyLogger.log.info("player " + this.name + " Current score: " + getScore());
        } else {
            MyLogger.log.trace(name + " lose 800 by lose the sea battle,and end the term");
            this.score -= 800;
            MyLogger.log.info("------------------End The " + this.name + " Term-------------------");
            MyLogger.log.info("player " + this.name + " Current score: " + getScore());
        }

    }


    public String getName() {
        return this.name;
    }

    public void print_dice_bag() {
        soft_bag();
        String str = "player " + name + " have dice: ";
        for (Dice i : dice_bag) {
            str = str.concat(i.face + " ");
        }
//       str= str.concat("---------------------");
        MyLogger.log.trace(str);
    }

    public void Init_round(Card card) throws Exception {
        //can move to cons
        for (int i = 0; i < dice_bag.length; i++) {
            dice_bag[i] = new Dice();
        }
        this.card = card;
        //if (card.getClass().equals(SeaBattle.class)) {
        //                    System.out.println("seabattlemode");
        //                    p2.changeMode(new AiBattleMode());
        //                }else{
//                            p2.changeMode( new AiCombMode(););
        //                }

        card.end_turn_check(this);
    }

    public void restart() {
        score = 0;
    }

    public void turn_act() throws Exception {
        System.out.println("player inter");
    }

    public void refresh_map() {
        for (Faces f : Faces.values()) {
            store_temp.put(f, 0);
        }
        for (Dice d : dice_bag) {
            store_temp.put(d.face, store_temp.get(d.face) + 1);
        }
    }

    public void soft_bag() {
        Arrays.sort(dice_bag, Comparator.comparing(o -> o.face));
    }

    public boolean sea_battle_state() {
        this.refresh_map();
        return this.store_temp.get(Faces.SABER) >= 3;
    }

    public void end_turn() {
        MyLogger.log.info("------------------End The " + this.name + " Term-------------------");
//        if (card.getClass().equals(SeaBattle.class)) {
//            seaBattle_Cal();
//        } else if (card.getClass().equals(MonkeyBusiness.class)) {
//
//
//        } else {
        card.score_cal(this);
//        }
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
            card.end_turn_check(this);
//            end_turn_check();
        } else {
            MyLogger.log.warn("not success reroll at least 2 valid,doing again");
//            System.out.println("not success reroll at least 2 valid,doing again");
            this.turn_act();
        }

    }

}
