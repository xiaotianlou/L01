package pk;

public class Player {
    String name;
    Dice ds = new Dice();
    Dice[] dice_bag = new Dice[8];

    public Player(String name) {
        this.name = name;
    }

    public void print_dice_bag() {
        System.out.print("player " + name + " have dice: ");
        for (Dice i : dice_bag) {
            System.out.print(i.face + " ");
        }
        System.out.println();
    }

    public void Init_round() {
        for (int i = 0; i < dice_bag.length; i++) {
            dice_bag[i] = new Dice();
        }
        print_dice_bag();
    }

    public void end_turn_check() {
    }

    public void re_roll(boolean[] index) {
        int valid_count = 0;
        for (int i = 0; i < 8; i++) {
            if (index[i] && dice_bag[i].face != Faces.SKULL) valid_count++;
        }
        if(valid_count>=2){
            for (int i = 0; i < 8; i++) {
                dice_bag[i].roll();
            }
        }

    }

}
