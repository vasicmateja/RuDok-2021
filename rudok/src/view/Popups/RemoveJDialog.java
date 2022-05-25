package view.Popups;

import controller.RemoveController;
import javax.swing.*;
import java.awt.*;

public class RemoveJDialog extends JDialog {

    RemoveController controller;

    public RemoveJDialog(JFrame frame, String title){
        super(frame, title);
    }

    public RemoveJDialog(RemoveController controller){
        this.controller = controller;
        init();
    }

    private void init() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screeWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(screeWidth/3, screenHeight/4);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel jp = new JPanel();

        Label lbl = new Label("Da li ste sigurni da želite da obrišete označeni element i sve unutar njega?");
        jp.add(lbl);
        Button btnConfirm = new Button("Da");
        btnConfirm.addActionListener(e -> {
            this.controller.OnConfirm();
        });
        jp.add(btnConfirm);
        Button btnDecline = new Button("Cancel");
        btnDecline.addActionListener(e-> {
            this.controller.onDecline();
        });
        jp.add(btnDecline);

        this.getContentPane().add(jp);
    }
}
