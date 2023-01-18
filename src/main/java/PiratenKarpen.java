import com.sun.source.tree.BinaryTree;
import pk.Dice;
import pk.Player;

public class PiratenKarpen {

    public static void main(String[] args) {

        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        System.out.println(myDice.roll());
        System.out.println("That's all folks!");
        Player p1 = new Player("p1");
        p1.Init_round();



    }


    //draft: skull lock,three skull stop with 0 except in island of skull

}
