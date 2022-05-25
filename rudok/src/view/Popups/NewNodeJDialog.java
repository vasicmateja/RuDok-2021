package view.Popups;

import controller.NewAction;
import controller.NewButtonController;
import javax.swing.*;
import java.awt.*;

public class NewNodeJDialog extends JDialog {

    public NewNodeJDialog(JFrame frame, String title) {
        super(frame, title);
        init();
    }

    public String className;

    NewButtonController newButtonController;
    NewAction newAction;


    public NewNodeJDialog(NewButtonController newButtonController) {
        this.newButtonController = newButtonController;
        init();

    }

    public NewNodeJDialog(NewAction newAction) {
        this.newAction = newAction;
        init2();

    }


    private void init() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screeWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(screeWidth / 4, screenHeight / 4);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel jp = new JPanel();

        Label lbl = new Label("Unesite željeno ime za klasu:");
        jp.add(lbl);
        TextField tf = new TextField();
        jp.add(tf);
        JButton btnOkay = new JButton("Okay");
        btnOkay.setSize(20, 5);
        btnOkay.addActionListener(e -> {

            this.newButtonController.onConfirm(tf.getText());
        });
        jp.add(btnOkay);
        //  btnOkay.setActionCommand(className = tf.getName().toString());
        this.getContentPane().add(jp);
    }


    private void init2() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screeWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(screeWidth / 4, screenHeight / 4);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel jp = new JPanel();

        Label lbl = new Label("Unesite željeno ime za klasu:");
        jp.add(lbl);
        TextField tf = new TextField();
        jp.add(tf);
        JButton btnOkay = new JButton("Okay");
        btnOkay.setSize(20, 5);
        btnOkay.addActionListener(e -> {
            this.newAction.onConfirm(tf.getText());
        });
        jp.add(btnOkay);
        this.getContentPane().add(jp);
    }
}