package commandPatern;

import model.RuNode;

public abstract class Command {
    RuNode ruNode;

    Command (RuNode ruNode){
        this.ruNode = ruNode;
    }
    public void doCommand(){}
    public void undoCommand(){}
}
