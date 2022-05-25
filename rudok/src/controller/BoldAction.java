package controller;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BoldAction extends AbstractRudokAction{
    JTextPane textPane;
    SimpleAttributeSet attributeSet;

    public BoldAction(){
        putValue(SMALL_ICON,loadIcon("D:\\Faks\\Dizajn softvera\\rudok-matejavasic8321rn\\rudok\\src\\view\\images\\bold.png"));
        putValue(NAME,"Bold");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        attributeSet = new SimpleAttributeSet();
        StyleConstants.setBold(attributeSet, true);
        textPane.setCharacterAttributes(attributeSet, true);
    }

    public void setTextPane(JTextPane textPane) {
        this.textPane = textPane;
    }
}
