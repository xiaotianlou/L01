import pk.*;

import java.util.Collections;
import java.util.LinkedList;

public class PiratenKarpen {
    static LinkedList<CardName> card_bag = new LinkedList<>();

    static {
        for (int i = 0; i < 35; i++) {
            if (i <= 5) {
                card_bag.add(CardName.Sea_Battle);
            } else {
                card_bag.add(CardName.nop);
            }
        }
        Collections.shuffle(card_bag);
    }
    public CardName get_card() {
        return card_bag.pop();
    }

    public static void main(String[] args) throws Exception {


        MyLogger.changeLoggerLevel("error");
        System.out.println("Welcome to Piraten Karpen Simulator1!");
        int total = 52;
        double p1w = 0;
        double p2w = 0;
        System.out.println(args[0]);
        AiStrategy ai1 = new Ai_rand_mode();
        AiStrategy ai2 = new Ai_rand_mode();
        if (args[0].equals("random combo")) {
            ai1 = new Ai_rand_mode();
            ai2 = new Ai_comb_mode();
        } else if (args[0].equals("combo combo")) {
            ai1 = new Ai_comb_mode();
            ai2 = new Ai_comb_mode();
        }

        Ai_player p1 = new Ai_player("p1", ai1);
        Ai_player p2 = new Ai_player("p2", ai2);
//        System.out.println("tresgrdhtygfcbvxdgfhjmbvngcbfxcgnvmhvnbvc");
//        System.out.println(p2.getScore());
//        p1.Init_round();
//        p2.Init_round();


        for (int i = 0; i < total; i++) {

            while (true) {
                p1.Init_round();
                Thread.sleep(0);
                p2.Init_round();
                if (p1.getScore() >= 6000 || p2.getScore() >= 6000) {
                    if (p1.getScore() == p2.getScore()) {
                        System.out.println("thay are same win");
                        p1.restart();
                        p2.restart();
                        break;
                    } else {
                        if (p1.getScore() > p2.getScore()) {
                            System.out.println(p1.getName() + " win");
                            p1w++;
                            p1.restart();
                            p2.restart();
                            break;
                        } else {
                            System.out.println(p2.getName() + " win");
                            p2w++;
                            p1.restart();
                            p2.restart();
                            break;
                        }
                    }
                }
            }

        }
        MyLogger.log.debug("p1:" + p1w / total);
        MyLogger.log.debug("p2:" + p2w / total);
        MyLogger.log.debug("+" + (p1w / total + p2w / total));
    }


//    static Logger log = LogManager.getLogger(PiratenKarpen.class);




    //draft: skull lock,three skull stop with 0 except in island of skull
//        for (int i = 0; i < 1000; i++) {
//
//
//            Player p = new Player("test");
//            p.print_dice_bag();
//            p.score_cal();
//            System.out.println();
//        }
}
