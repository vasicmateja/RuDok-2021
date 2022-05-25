package view.Popups;

import simpleFactory.ErrorFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserJDialog extends JDialog {

    JColorChooser colorChooserJDialog;
    JTextField tfHeight;
    JTextField tfWidth;
    Button btnConfirm;

    public ColorChooserJDialog(){

        init();
    }

    private void init() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screeWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(screeWidth / 2, screenHeight / 2);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel jPanelGlavni= new JPanel();
        jPanelGlavni.setLayout(new BoxLayout(jPanelGlavni, BoxLayout.Y_AXIS));

        colorChooserJDialog = new JColorChooser();
        jPanelGlavni.add(colorChooserJDialog);


        JPanel jPanelHeight = new JPanel();
        tfHeight = new JTextField();
        tfHeight.setPreferredSize(new Dimension(60,20));
        jPanelHeight.add(new JLabel("Height: "));
        jPanelHeight.add(tfHeight);
        jPanelGlavni.add(jPanelHeight);

        JPanel jPanelWidth = new JPanel();
        tfWidth = new JTextField();
        tfWidth.setPreferredSize(new Dimension(60,20));
        jPanelWidth.add(new JLabel("Width"));
        jPanelWidth.add(tfWidth);
        jPanelGlavni.add(jPanelWidth);

        btnConfirm = new Button("Confirm");
        btnConfirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Color color = colorChooserJDialog.getColor();
                int height = Integer.parseInt(tfHeight.getText());
                int width = Integer.parseInt(tfWidth.getText());
                }catch (NumberFormatException exception) {
                    ErrorFactory.createError("slotpopupgreska");
                }
            }
        });

        jPanelGlavni.add(btnConfirm);

        this.getContentPane().add(jPanelGlavni);

    }

    public JColorChooser getColorChooserJDialog() {
        return colorChooserJDialog;
    }

    public JTextField getTfHeight() {
        return tfHeight;
    }

    public JTextField getTfWidth() {
        return tfWidth;
    }
}
