import pk.*;

import java.util.Collections;
import java.util.LinkedList;

public class PiratenKarpen {
    static LinkedList<Card> card_bag = new LinkedList<>();

    static {
        loading_card_bag();
    }

    public static void loading_card_bag() {
        for (int i = 0; i < 35; i++) {
            if (i <= 5) {
                card_bag.add(new SeaBattle());
            } else {
                card_bag.add(new NopeCard());
            }
        }

//        for (int i = 0; i < 35; i++) {
//            if (i <= 35) {
//                card_bag.add(new SeaBattle());
//            } else {
//                card_bag.add(new NopeCard());
//            }
//        }
        Collections.shuffle(card_bag);
    }

    public static Card cardDraw() {
        if (card_bag.peek() == null) {
            loading_card_bag();
        }

        return card_bag.pop();
    }


    public static void main(String[] args) throws Exception {


        MyLogger.changeLoggerLevel("trace");
        System.out.println("1");
        System.out.println("Welcome to Piraten Karpen Simulator1!");
        int total = 52;
        double p1w = 0;
        double p2w = 0;

        AiStrategy ai1 = new AiRandMode();
        AiStrategy ai2 = new AiRandMode();

        if (args.length != 0) {
            if (args[0].equals("random combo")) {
                ai1 = new AiRandMode();
                ai2 = new AiCombMode();
            } else if (args[0].equals("combo combo")) {
                ai1 = new AiCombMode();
            ai2 = new AiCombMode();

            }
        }

        AiPlayer p1 = new AiPlayer("p1", ai1);
        AiPlayer p2 = new AiPlayer("p2", ai2);
//        System.out.println("tresgrdhtygfcbvxdgfhjmbvngcbfxcgnvmhvnbvc");
//        System.out.println(p2.getScore());
//        p1.Init_round();
//        p2.Init_round();


        for (int i = 0; i < total; i++) {

            while (true) {
                MyLogger.log.info("=======================================this is " + i + " games ====================================");

                Card card1 = cardDraw();
                Card card2 = cardDraw();
                p1.Init_round(card1);
//                Thread.sleep(20);

                if (card2.getClass().equals(SeaBattle.class)) {
                    System.out.println("海战模式");
                    p2.changeMode(new AiBattleMode());
                }else{
                    p2.changeMode(ai2);
                }
                p2.Init_round(card2);


                if (p1.getScore() >= 6000 || p2.getScore() >= 6000) {
                    if (p1.getScore() == p2.getScore()) {
                        System.out.println("thay are win together");
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
        MyLogger.log.debug("p1 win:" + p1w / total);
        MyLogger.log.debug("p2 win:" + p2w / total);
        MyLogger.log.debug("same win: " + (1 - (p1w / total + p2w / total)));
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
