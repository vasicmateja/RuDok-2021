package controller;

import DataStorage.DataStorage;
import model.Project;
import view.MainFrame;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class SaveProjectAction implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new ProjecFileFilter());

        Project project = DataStorage.getInstance().project;
        File projectFile = project.getFile();

        if (!project.isChanged()){
            return;
        }

        if (project.getFile()==null){
            if(jFileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                projectFile=jFileChooser.getSelectedFile();

            }else{
                return;
            }

        }


        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(projectFile));
            os.writeObject(project);
            project.setFile(projectFile);
            project.setChanged(false);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
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
