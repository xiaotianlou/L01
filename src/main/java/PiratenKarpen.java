import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pk.*;

public class PiratenKarpen {
    public static void startMode(String[] args) {
        if (args.length != 0) {
            switch (args[0]) {
                case "debug":
                    MyLogger.changeLoggerLevel("debug");
                    break;
                case "info":
                    MyLogger.changeLoggerLevel("info");
                    break;
                case "warn":
                    MyLogger.changeLoggerLevel("warn");
                    break;
                case "error":
                    MyLogger.changeLoggerLevel("error");
                    break;
                case "fatal":
                    MyLogger.changeLoggerLevel("fatal");
                case "trace":
                    MyLogger.changeLoggerLevel("trace");
                default:
                    break;
            }


        }

    }

    static Logger log = LogManager.getLogger(PiratenKarpen.class);

    public static void main(String[] args) throws Exception {
//        MyLogger.changeLoggerLevel("trace");
        startMode(args);
        System.out.println("Welcome to Piraten Karpen Simulator!");
        int total = 42;
        double p1w = 0;
        double p2w = 0;

        AiStrategy ai1 = new Ai_rand_mode();
        AiStrategy ai2 = new Ai_comb_mode();

        Ai_player p1 = new Ai_player("p1", ai1);
        Ai_player p2 = new Ai_player("p2", ai2);

        for (int i = 0; i < total; i++) {
            while (true) {
                p1.Init_round();
                p2.Init_round();
                if (p1.getScore() >= 6000) {
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
        log.debug("p1:" + p1w / total);
        log.debug("p2:" + p2w / total);
        log.debug("+" + (p1w / total + p2w / total));
    }


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
