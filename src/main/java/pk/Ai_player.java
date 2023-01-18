package pk;

public class Ai_player extends Player{
    AiStrategy mode;
    public Ai_player(String name, AiStrategy mode) {
        super(name);
        this.mode=mode;
    }
    public void turn_acting() {
        mode.turn_acting(this);
    }


}
