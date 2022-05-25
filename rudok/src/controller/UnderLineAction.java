package controller;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.event.ActionEvent;

public class UnderLineAction extends AbstractRudokAction{
    JTextPane textPane;
    SimpleAttributeSet attributeSet;

    public UnderLineAction(){
        putValue(SMALL_ICON,loadIcon("D:\\Faks\\Dizajn softvera\\rudok-matejavasic8321rn\\rudok\\src\\view\\images\\underline.png"));
        putValue(NAME,"Underline");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        attributeSet = new SimpleAttributeSet();
        StyleConstants.setUnderline(attributeSet, true);
        textPane.setCharacterAttributes(attributeSet, true);

    }

    public void setTextPane(JTextPane textPane) {
        this.textPane = textPane;
    }
}
