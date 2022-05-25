package controller;

import view.MainFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class UndoAction extends AbstractRudokAction{

    public UndoAction(){
        putValue(SMALL_ICON,loadIcon("D:\\Faks\\Dizajn softvera\\rudok-matejavasic8321rn\\rudok\\src\\view\\images\\undo.png"));
        putValue(NAME,"Undo");
        this.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getCommandManager().undoCommand();
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getJspLevi());
    }
}
