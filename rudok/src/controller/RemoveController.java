package controller;

import DataStorage.DataStorage;
import commandPatern.RemoveRuNodeCommand;
import model.RuNode;
import model.Slide;
import observerPackage.Observer;
import view.MainFrame;
import view.Popups.RemoveJDialog;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RemoveController implements MouseListener{

    RemoveJDialog removeJDialog;
    RuNode selectedNode;
    Observer<RuNode> observer = new Observer<RuNode>((value -> this.rerender())) ;

    public RemoveController(){
        DataStorage.getInstance().observableTreeUpdate.subscribe(observer);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        removeJDialog= new RemoveJDialog(this);
        removeJDialog.setVisible(true);
    }

    public void OnConfirm(){
        this.removeJDialog.dispose();
        selectedNode = DataStorage.getInstance().selected;
        MainFrame.getInstance().getCommandManager().addCommand(new RemoveRuNodeCommand(selectedNode));
        if(selectedNode instanceof Slide){
            DataStorage.getInstance().slide = null;
        }

        SwingUtilities.invokeLater(() -> {
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getJspLevi());
        });
        DataStorage.getInstance().observableTreeUpdate.next(selectedNode);

    }

    public void onDecline(){
        this.removeJDialog.dispose();
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

    public void rerender(){
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getJspLevi());

    }
}
