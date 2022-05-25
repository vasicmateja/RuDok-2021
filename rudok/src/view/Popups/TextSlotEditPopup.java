package view.Popups;

import DataStorage.DataStorage;
import model.TextSlot;
import view.MainFrame;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class TextSlotEditPopup extends JDialog {

    JTextPane jTextPane;
    JToolBar jToolBar;
    JButton jbBold;
    JButton jbItalic;
    JButton jbUnderline;
    JButton jbConfirm;

    public TextSlotEditPopup(TextSlot slot){
        init(slot);
    }

    private void init(TextSlot slot){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screeWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(screeWidth / 4, screenHeight / 4);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel jp = new JPanel();
        jp.setBackground(Color.pink);
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jTextPane = new JTextPane();

        jToolBar = new JToolBar();
        jbBold = new JButton();
        jbItalic = new JButton();
        jbUnderline = new JButton();
        jToolBar.setFloatable(false);
        jToolBar.setPreferredSize(new Dimension(jp.getWidth(), 40));


        jToolBar.add(MainFrame.getInstance().getActionManager().getBoldAction());
        MainFrame.getInstance().getActionManager().getBoldAction().setTextPane(jTextPane);
        jToolBar.add(MainFrame.getInstance().getActionManager().getItalicAction());
        MainFrame.getInstance().getActionManager().getItalicAction().setTextPane(jTextPane);
        jToolBar.add(MainFrame.getInstance().getActionManager().getUnderLineAction());
        MainFrame.getInstance().getActionManager().getUnderLineAction().setTextPane(jTextPane);

        jp.add(jToolBar);


        jp.add(jTextPane);

        jbConfirm = new JButton("Confirm");
        jbConfirm.addActionListener(e -> {
                this.setVisible(false);

            String text= "";
            AttributeSet style;
            String boldedString = "&&";
            String italicString = "//";
            String underlineString = "__";
            String regularString = "";

                for(int i =0; i < jTextPane.getText().length(); i++) {
                    style = jTextPane.getStyledDocument().getCharacterElement(i).getAttributes();

                    if (StyleConstants.isBold(style)) {
                        boldedString += String.valueOf(jTextPane.getText().charAt(i));

                        if (i + 1 >= jTextPane.getText().length()) {
                            boldedString += "&&";
                            text += boldedString;
                            boldedString = "&&";
                        } else {
                            style = jTextPane.getStyledDocument().getCharacterElement(i + 1).getAttributes();

                            if (!StyleConstants.isBold(style)) {
                                boldedString += "&&";
                                text += boldedString;
                                boldedString = "&&";
                            }
                        }

                    } else if (StyleConstants.isItalic(style)) {

                        italicString += String.valueOf(jTextPane.getText().charAt(i));

                        if (i + 1 >= jTextPane.getText().length()) {
                            italicString += "//";
                            text += italicString;
                            italicString = "//";
                        } else {
                            style = jTextPane.getStyledDocument().getCharacterElement(i + 1).getAttributes();

                            if (!StyleConstants.isItalic(style)) {
                                italicString += "//";
                                text += italicString;
                                italicString = "//";
                            }
                        }
                    } else if (StyleConstants.isUnderline(style)) {

                        underlineString += String.valueOf(jTextPane.getText().charAt(i));

                        if (i + 1 >= jTextPane.getText().length()) {
                            underlineString += "__";
                            text += underlineString;
                            underlineString = "__";
                        } else {
                            style = jTextPane.getStyledDocument().getCharacterElement(i + 1).getAttributes();

                            if (!StyleConstants.isUnderline(style)) {
                                underlineString += "__";
                                text += underlineString;
                                italicString = "__";
                            }
                        }
                    }else {
                        regularString += String.valueOf(jTextPane.getText().charAt(i));
                        if(i+1 >= jTextPane.getText().length()){
                            regularString += "";
                            text += regularString;
                            regularString = "";
                        }else {
                            regularString += "";
                            text += regularString;
                            regularString ="";
                        }
                    }
                }
                slot.setText(text);
                DataStorage.getInstance().slide.trigger();
        });
        jp.add(jbConfirm);

        this.getContentPane().add(jp);
    }

}
