package commandPatern;

import model.RuNode;

public class RenameRuNodeCommand extends Command{

    RenameRuNodeCommand(RuNode ruNode) {
        super(ruNode);
    }

    @Override
    public void doCommand() {

    }

    @Override
    public void undoCommand() {

    }
}
