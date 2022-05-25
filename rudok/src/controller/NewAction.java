package controller;

import DataStorage.DataStorage;
import commandPatern.AddRuNodeCommand;
import factory.AbstractRuNodeFactory;
import model.RuNodeComp;
import view.MainFrame;
import view.Popups.NewNodeJDialog;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewAction extends AbstractRudokAction {

    NewNodeJDialog newNodeJDialog;

    public NewAction(){
        putValue(SMALL_ICON,loadIcon("D:\\Faks\\Dizajn softvera\\rudok-matejavasic8321rn\\rudok\\src\\view\\images\\new16x16.jpg"));
        putValue(NAME,"New");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        newNodeJDialog = new NewNodeJDialog(this);
        newNodeJDialog.setVisible(true);
    }

    public void onConfirm(String text) {
        if(text == null){
            //ubaci error handler
        }
        newNodeJDialog.dispose();

        RuNodeComp selected = (RuNodeComp) DataStorage.getInstance().selected;
        MainFrame.getInstance().getCommandManager().addCommand(new AddRuNodeCommand(new AbstractRuNodeFactory.Builder().build(text, selected)));
        DataStorage.getInstance().project.setChanged(true);
        SwingUtilities.invokeLater(() -> {
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getJspLevi());
        });

    }
}
