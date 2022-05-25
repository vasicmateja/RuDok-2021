package view.modelViews;


import controller.PresentationController;
import controller.ProjectController;
import model.Project;
import model.RuNode;
import observerPackage.Observer;
import javax.swing.*;
import java.awt.*;


public class ProjectView {

    ProjectController controller;
    JTabbedPane tabbedPane;

    public  ProjectView(ProjectController controller){
        this.controller = controller;
        this.tabbedPane = new JTabbedPane();
    }

    private JTabbedPane getProjectTabbedPane(Project project){
        Dimension min = new Dimension(800,800);
        tabbedPane.setMinimumSize(min);
        project.lista.forEach(c -> tabbedPane.add(c.getName(), new PresentationController().renderDesni()));
        return tabbedPane;
    }

    public JTabbedPane getLayout(Project project){
        JLabel jLabel = new JLabel(project.name);
        return getProjectTabbedPane(project);
    }

    public void rerender(Project newProject) {
        tabbedPane.removeAll();
        newProject.lista.forEach(presentation -> tabbedPane.add(presentation.getName(), new PresentationController().renderDesni()));
        SwingUtilities.invokeLater(() -> {
            tabbedPane.updateUI();
        });
    }

    private void subscribeToChange(Project project){
        project.subscribe(new Observer<RuNode>(value -> rerender(project)));
    }
}
