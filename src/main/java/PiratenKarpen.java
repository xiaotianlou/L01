import pk.AiStrategy;
import pk.Ai_player;
import pk.Ai_rand_mode;

public class PiratenKarpen {


    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to Piraten Karpen Simulator!");
        int total;
        int p1w = 0;
        intp2w = 0;
        AiStrategy ai = new Ai_rand_mode();
        Ai_player p1 = new Ai_player("p1", ai);
        Ai_player p2 = new Ai_player("p2", ai);

        for (int i = 0; i < 48; i++) {
            while (true) {
                p1.Init_round();
                p2.Init_round();
                if (p1.getScore() > 6000) {
                    if (p1.getScore() == p2.getScore()) {
                        System.out.println("thay are same win");
                        break;
                    } else {
                        if (p1.getScore() > p2.getScore()) {
                            System.out.println(p1.getName() + " win");
                            break;
                        } else {
                            System.out.println(p2.getName() + " win");
                            break;
                        }
                    }
                }
            }

        }
    }


    //draft: skull lock,three skull stop with 0 except in island of skull

}
