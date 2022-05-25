package view.Popups;

import javax.swing.*;
import java.awt.*;

public class JDialogErrorSlotPopup extends JDialog {


    public JDialogErrorSlotPopup(JFrame frame, String title){
        super(frame, title);
    }

    public JDialogErrorSlotPopup(){
        init();
    }

    private void init() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screeWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(screeWidth / 3, screenHeight / 4);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Label lbl = new Label("Height and width must be set and typed in numbers");
        this.getContentPane().add(lbl);
    }
}
