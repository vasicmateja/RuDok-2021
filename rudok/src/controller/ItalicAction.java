package controller;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.event.ActionEvent;

public class ItalicAction extends AbstractRudokAction{

    JTextPane textPane;
    SimpleAttributeSet attributeSet;

    public ItalicAction(){
            putValue(SMALL_ICON,loadIcon("D:\\Faks\\Dizajn softvera\\rudok-matejavasic8321rn\\rudok\\src\\view\\images\\italic.png"));
            putValue(NAME,"Italic");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        attributeSet = new SimpleAttributeSet();
        StyleConstants.setItalic(attributeSet, true);
        textPane.setCharacterAttributes(attributeSet, true);
    }

    public void setTextPane(JTextPane textPane) {
        this.textPane = textPane;
    }
}
