package commandPatern;

import DataStorage.DataStorage;
import model.*;
import view.MainFrame;

import javax.swing.*;

public class AddRuNodeCommand extends Command{
    RuNode selectedRuNode = DataStorage.getInstance().selected;
    public  AddRuNodeCommand(RuNode ruNode) {
        super(ruNode);
    }

    @Override
    public void doCommand() {

        if(selectedRuNode instanceof WorkSpace)
            ((WorkSpace) selectedRuNode).addProject((Project) ruNode);
        if(selectedRuNode instanceof Project)
            ((Project) selectedRuNode).addPresentation((Presentation) ruNode);
        if(selectedRuNode instanceof Presentation)
            ((Presentation) selectedRuNode).addSlide((Slide) ruNode);
    }

    @Override
    public void undoCommand() {
        ruNode.remove();
        SwingUtilities.invokeLater(() -> {
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getJspLevi());
        });
    }
}
