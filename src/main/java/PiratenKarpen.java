import pk.AiStrategy;
import pk.Ai_player;
import pk.Ai_rand_mode;

public class PiratenKarpen {


    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to Piraten Karpen Simulator!");
        int total = 42;
        double p1w = 0;
        double p2w = 0;

        AiStrategy ai1 = new Ai_rand_mode();
        AiStrategy ai2 = new Ai_rand_mode();

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
        System.out.println("p1:" + p1w / total);
        System.out.println("p2:" + p2w / total);
        System.out.println("+" + (p1w / total + p2w / total));
    }


    //draft: skull lock,three skull stop with 0 except in island of skull

}
