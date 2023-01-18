import com.sun.source.tree.BinaryTree;
import pk.*;

public class PiratenKarpen {

    public static void main(String[] args) {

        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        System.out.println(myDice.roll());
        System.out.println("That's all folks!");
        AiStrategy ai = new Ai_rand_mode();
        Ai_player p1 = new Ai_player("p1",ai);
        p1.Init_round();
        Ai_player p2 = new Ai_player("p2",ai);

    }


    //draft: skull lock,three skull stop with 0 except in island of skull

}
