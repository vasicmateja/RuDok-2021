package view.Popups;

import javax.swing.*;
import java.awt.*;

public class InfoJDialog extends JDialog {

    public InfoJDialog(JFrame frame , String title){
        super(frame, title);
        init();
    }

    public InfoJDialog(){
        init();
    }

    private void init() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screeWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(screeWidth/2, screenHeight/2);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        String myPicPath = "D:\\Faks\\Dizajn softvera\\rudok-matejavasic8321rn\\rudok\\src\\view\\images\\myPic.jpg";
      //  ImagePanel imagePanel = new ImagePanel(myPicPath);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        jPanel.add(new JLabel("Mateja Vasic 83/21 RN", JLabel.CENTER));
//        jPanel.add(myPic);
        this.getContentPane().add(jPanel);
    }
}
