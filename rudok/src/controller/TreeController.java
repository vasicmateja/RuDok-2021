package controller;

import DataStorage.DataStorage;
import model.*;
import view.TreeStructure;
import java.util.List;

public class TreeController {

    public TreeStructure view = new TreeStructure(this);


    public RuNode findRuNode(List<String> path) {
        WorkSpace workspace = DataStorage.getInstance().workSpace;
        if(path.size() == 1){
            return workspace;
        }
        Project project = workspace.findChild(path.get(1));
        if(path.size() == 2) {
            return project;
        }
        Presentation presentation = project.findChild(path.get(2));
        if(path.size() == 3){
            return presentation;
        }
        return presentation.findChild(path.get(3));
    }

    public void onEvent(List<String> path) {
        if(path == null){
            return;
        }
        RuNode node = this.findRuNode(path);
        DataStorage.getInstance().setSelectedTreeNode(node);

    }

    /*
    public RuNodeComp findRuNodeComp(List<String> path) {
        WorkSpace workspace = DataStorage.getInstance().workSpace;
        if(path.size() == 1) {
            return workspace;
        }
        Project project = workspace.findChild(path.get(1));
        if(path.size() == 2) {
            return project;
        }
        return project.findChild(path.get(2));
    }
     */

}
