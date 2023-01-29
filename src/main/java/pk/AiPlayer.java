package pk;

public class AiPlayer extends Player {
    AiStrategy mode;

    public AiPlayer(String name, AiStrategy mode) {
        super(name);
        this.mode = mode;
    }
    public void changeMode(AiStrategy ai){
        this.mode=ai;

    }

    public void turn_act() throws Exception {
        mode.turn_acting(this);
    }


}
