package view;

import javax.swing.*;

public class Toolbar extends JToolBar {

    public Toolbar(){

        setFloatable(false);
        add(MainFrame.getInstance().getActionManager().getInfoAction());
        add(MainFrame.getInstance().getActionManager().getNewAction());
        add(MainFrame.getInstance().getActionManager().getShareAction());
        add(MainFrame.getInstance().getActionManager().getUndoAction());
        add(MainFrame.getInstance().getActionManager().getRedoAction());
    }
}
