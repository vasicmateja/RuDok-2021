package controller;

import view.MainFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class RedoAction extends AbstractRudokAction{

    public RedoAction(){
        putValue(SMALL_ICON,loadIcon("D:\\Faks\\Dizajn softvera\\rudok-matejavasic8321rn\\rudok\\src\\view\\images\\redo.png"));
        putValue(NAME,"Redo");
        this.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getCommandManager().doCommand();
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getJspLevi());
    }

}
