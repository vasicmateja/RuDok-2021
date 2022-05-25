package controller;

import DataStorage.DataStorage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChangeStateController implements MouseListener {
    private boolean isPresenting = false;
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        isPresenting = !isPresenting;
        DataStorage.getInstance().stateChange.next(isPresenting);
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
