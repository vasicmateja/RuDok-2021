package model;

import java.io.Serializable;

public class WorkSpace extends RuNodeComp<Project> implements Serializable {

    public WorkSpace(String name){
        super(name);
    }

    @Override
    public void addNewChild(Project child) {
        this.addChild(child);
    }

    public void addProject(String name){
        this.addChild(new Project(name));
    }

    public void addProject(Project project){
        this.addChild(project);
    }
}
