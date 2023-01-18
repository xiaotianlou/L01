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
//            System.out.println("Skull can not reroll,Automatically ignored");
            return face;
        }

        int howManyFaces = Faces.values().length;
//        System.out.println("  (DEBUG) there are " + howManyFaces + " faces");
//        System.out.println("  (DEBUG) " + Arrays.toString(Faces.values()));
        Random bag = new Random();
        face = Faces.values()[bag.nextInt(howManyFaces)];
        return face;
    }

}
