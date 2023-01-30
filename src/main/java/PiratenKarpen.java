import org.apache.commons.cli.*;
import pk.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

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
        Collections.shuffle(card_bag);
    }

    public static Card cardDraw() {
        if (card_bag.peek() == null) {
            loading_card_bag();
        }
        return card_bag.pop();
    }


    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("input the log level you want (trace,fatal,error,warn,info,debug)");
        String loglevel = s.nextLine().trim().toLowerCase();
        MyLogger.changeLoggerLevel(loglevel);

        System.out.println("Welcome to Piraten Karpen Simulator1!");
        int total = 52;
        AiStrategy ai1 = new AiCombMode();
        AiStrategy ai2 = new AiCombMode();

        Options options = new Options();
        Option alpha = new Option("cc", "combo combo", false, "combo choose for player");
        options.addOption(alpha);
        Option config = Option.builder("n").longOpt("number")//Here the builder reports an error but it actually compiles and functions fine, idk why :)
                .argName("numberofsi")
                .hasArg()
                .required(true)
                .desc("set number of simulation").build();
        options.addOption(config);

// define parser
        CommandLine cmd;
        CommandLineParser parser = new BasicParser();
        HelpFormatter helper = new HelpFormatter();
        try {
            cmd = parser.parse(options, args);
            if(cmd.hasOption("cc")){
                System.out.println( "has option");
                ai1 = new AiCombMode();
                ai2 = new AiCombMode();
            }
            if (cmd.hasOption("n")) {
                int opt_config = Integer.parseInt(cmd.getOptionValue("number"));
                total=opt_config;
            }
            if (!cmd.hasOption("cc")&&!cmd.hasOption("n")&&args.length!=0) {
                String[] input = args[0].split(" ");

                if (input[0].equals("random")) ai1 = new AiRandMode();
                if (input[0].equals("combo")) ai1 = new AiCombMode();
                if (input[0].equals("seabattle")) ai1 = new AiBattleMode();

                if (input[1].equals("random")) ai2 = new AiRandMode();
                if (input[1].equals("combo")) ai2 = new AiCombMode();
                if (input[1].equals("seabattle")) ai2 = new AiBattleMode();

            }
        }catch (Exception e){
            e.printStackTrace();
        }




        double p1w = 0;
        double p2w = 0;

        AiPlayer p1 = new AiPlayer("p1", ai1);
        AiPlayer p2 = new AiPlayer("p2", ai2);

//start game
        for (int i = 0; i < total; i++) {
            while (true) {
                MyLogger.log.info("=======================================this is " + (i+1) + " games ====================================");

                Card card1 = cardDraw();
                Card card2 = cardDraw();
                p1.Init_round(card1);
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
                }// winner cal
            }
        }
        //stop game

        MyLogger.log.debug("p1 win:" + p1w / total);
        MyLogger.log.debug("p2 win:" + p2w / total);
        MyLogger.log.debug("same win: " + (1 - (p1w / total + p2w / total)));
    }

}
