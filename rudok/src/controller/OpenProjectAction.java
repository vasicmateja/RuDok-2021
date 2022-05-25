package controller;

import DataStorage.DataStorage;
import model.Project;
import view.MainFrame;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenProjectAction implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new ProjecFileFilter());

        if (jFileChooser.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jFileChooser.getSelectedFile()));

                Project p = null;
                try {
                    p = (Project) os.readObject();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }


                DataStorage.getInstance().workSpace.addProject(p);
                SwingUtilities.invokeLater(() -> {
                    SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getJspLevi());
                });


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
