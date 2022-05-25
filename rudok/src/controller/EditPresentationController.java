package controller;

import DataStorage.DataStorage;
import model.Presentation;
import model.RuNode;
import view.MainFrame;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EditPresentationController implements MouseListener {

    RuNode presentation;

    @Override
    public void mouseClicked(MouseEvent e) {

        presentation = DataStorage.getInstance().selected;

        if(presentation instanceof Presentation){
            MainFrame.getInstance().getjTabbedPane().addTab(((Presentation) presentation).getName(), new Panel());
        }else{
            System.out.print("Videcemo");
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
