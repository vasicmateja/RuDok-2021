package controller;

import DataStorage.DataStorage;
import model.WorkSpace;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAllAction implements MouseListener {

    FileWriter fw;
    JFileChooser jFileChooser = new JFileChooser();

    @Override
    public void mouseClicked(MouseEvent e) {
        WorkSpace workspace = DataStorage.getInstance().workSpace;
        String workspacePath;

        if(jFileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
            //treba prvo napraviti fajl za save u sistemu
            workspacePath = jFileChooser.getSelectedFile().getPath();

        }else{
            return;
        }

        try {
            fw = new FileWriter(workspacePath);
            FileWriter finalFw = fw;
            workspace.lista.forEach(project -> {

                try {
                    finalFw.write(project.getFile().getPath());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
