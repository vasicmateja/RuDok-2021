package controller;

import DataStorage.DataStorage;
import commandPatern.AddRuNodeCommand;
import factory.AbstractRuNodeFactory;
import model.RuNodeComp;
import view.MainFrame;
import view.Popups.NewNodeJDialog;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NewButtonController implements MouseListener {

    NewNodeJDialog newNodeJDialog;

    public NewButtonController(){

    }

    @Override
    public void mouseClicked(MouseEvent e) {
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


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
