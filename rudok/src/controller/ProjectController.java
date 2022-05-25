package controller;

import DataStorage.DataStorage;
import model.Project;
import model.RuNode;
import observerPackage.Observer;
import view.modelViews.ProjectView;

import javax.swing.*;

public class ProjectController {

    ProjectView projectView = new ProjectView(this);
    Observer<RuNode> observer = new Observer<RuNode>((value -> this.rerender())) ;

    public ProjectController(){
        DataStorage.getInstance().observableTreeUpdate.subscribe(observer);
    }

    public JTabbedPane render(){

        Project project = DataStorage.getInstance().project;

        return projectView.getLayout(project);
    }

    public void rerender(){
        projectView.rerender(DataStorage.getInstance().project);
    }
}
