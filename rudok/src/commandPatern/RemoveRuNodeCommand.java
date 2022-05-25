package commandPatern;

import model.RuNode;

public class RemoveRuNodeCommand extends Command{

   public RemoveRuNodeCommand(RuNode ruNode) {
        super(ruNode);
    }

    @Override
    public void doCommand() {
        ruNode.remove();
    }

    @Override
    public void undoCommand() {
        ruNode.getParent().addChild(ruNode);
    }
}
