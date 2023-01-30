package pk;

import java.util.Random;

public class Dice {
    Faces face;

    public Dice() {
        face = this.roll();
    }

    public Faces roll() {
        if (face == Faces.SKULL) {
            //card not cont
            //Skull can not reroll,Automatically ignored
            return face;
        }
        int howManyFaces = Faces.values().length;

        Random bag = new Random();
        face = Faces.values()[bag.nextInt(howManyFaces)];
        return face;
    }

}
