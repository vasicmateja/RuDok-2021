package controller;

import DataStorage.DataStorage;
import model.Presentation;
import view.MainFrame;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class SavePresentation implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new ProjecFileFilter());

        Presentation presentation = DataStorage.getInstance().presentation;
        File presentationFile = presentation.getFile();

        if (!presentation.isChanged()){
            return;
        }

        if (presentation.getFile()==null){
            if(jFileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                presentationFile=jFileChooser.getSelectedFile();

            }else{
                return;
            }

        }


        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(presentationFile));
            os.writeObject(presentation);
            presentation.setFile(presentationFile);
            presentation.setChanged(false);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
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
