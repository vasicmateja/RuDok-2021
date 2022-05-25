package model;

import view.MainFrame;
import javax.swing.*;
import java.io.File;
import java.io.Serializable;

public class Project extends RuNodeComp<Presentation> implements Serializable {

    public String name;
    public File file;
    private transient boolean changed;

    public Project(String name){
        super(name);
        this.name = name;
        this.changed = false;
        this.file=null;
    }

    @Override
    public void addNewChild(Presentation child) {
        this.addChild(child);
    }

    public void addPresentation(String name){

        this.addChild(new Presentation(name));
    }

    public void addPresentation(Presentation presentation){
        this.addChild(presentation);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isChanged() {
        return changed;
    }


    public void setChanged(boolean changed) {
        if (this.changed!=changed){
            this.changed=changed;
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getJspLevi());
        }
    }
}
