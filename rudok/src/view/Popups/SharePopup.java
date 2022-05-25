package view.Popups;

import DataStorage.DataStorage;
import model.Presentation;
import model.Project;
import view.MainFrame;
import javax.swing.*;
import java.awt.*;

public class SharePopup extends JDialog {
    JPanel jPanel;
    JButton jButton;

    public SharePopup(Presentation currPresentation){
        init(currPresentation);
    }

    private void init(Presentation currPresentation) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screeWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(screeWidth / 4, screenHeight / 4);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBackground(Color.orange);
        addProjects(currPresentation);

        this.getContentPane().add(jPanel);
    }

    private void addProjects(Presentation currPres){
        for(Project project: DataStorage.getInstance().workSpace.lista){
            jButton = new JButton(project.name);
            setBtnAction(jButton, currPres);
            jPanel.add(jButton);
            jButton.setPreferredSize(new Dimension(70, 70));
        }
    }

    private void setBtnAction(JButton jButton, Presentation currPres) {

        jButton.addActionListener(e -> {
            for (Project project: DataStorage.getInstance().workSpace.lista){
                if(project.name.equals(jButton.getText())){
                    currPres.sharePresentation(project);

                    SwingUtilities.invokeLater(() -> {
                        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getJspLevi());
                    });
                    this.dispose();
                }
            }
        });

    }
}
