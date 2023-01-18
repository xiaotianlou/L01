package pk;

import java.util.Random;

public class Dice {
    Faces face;

    public Dice() {
        face = this.roll();
    }

    public Faces roll() {
        int howManyFaces = Faces.values().length;
//        System.out.println("  (DEBUG) there are " + howManyFaces + " faces");
//        System.out.println("  (DEBUG) " + Arrays.toString(Faces.values()));
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }

}
