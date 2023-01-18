package pk;

import com.sun.source.tree.BinaryTree;

import java.util.Arrays;

public class Player {
    String name;
    Dice ds=new Dice();
    Dice dice_bag[] =new Dice[8];
    public Player(String name){
        this.name=name;
    }

    public void Init_round(){
        for (int i = 0; i < dice_bag.length; i++) {
            dice_bag[i]=new Dice();
        }
        System.out.println(Arrays.toString(dice_bag));

    }

}
