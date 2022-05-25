package view.Popups;

import javax.swing.*;
import java.awt.*;

public class SlideFromParentJDialog extends JDialog {


    public SlideFromParentJDialog(JFrame frame, String title){
        super(frame, title);
    }

    public SlideFromParentJDialog(){
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

        Label lbl = new Label("Selektujte prezentaciju gde želite napravi slajd");
        this.getContentPane().add(lbl);
    }
}
