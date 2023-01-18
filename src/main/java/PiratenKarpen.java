import com.sun.source.tree.BinaryTree;
import pk.*;

public class PiratenKarpen {


    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to Piraten Karpen Simulator!");

        AiStrategy ai = new Ai_rand_mode();
        Ai_player p1 = new Ai_player("p1",ai);
        Ai_player p2 = new Ai_player("p2",ai);
        for (int i = 0; i <50 ; i++) {
            p1.Init_round();
            p2.Init_round();
            if(p1)
        }
    }


    //draft: skull lock,three skull stop with 0 except in island of skull

}
