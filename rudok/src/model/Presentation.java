package model;

import DataStorage.DataStorage;
import view.MainFrame;
import javax.swing.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Presentation extends RuNodeComp<Slide> implements Serializable {

    public File file;
    private transient boolean changed;
    ArrayList<Presentation> sharedPresentations;
    Presentation original;

    public Presentation(String name){
        super(name);
        this.changed=true;
        this.file=null;
    }

    public void addSlide(String name){
        this.addChild(new Slide(name));
    }

    public void addSlide(Slide slide){
        this.addChild(slide);
    }

    public String getName() {

        return name;
    }

    public void addNewChild(Slide child){
        this.addChild(child);
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

    public void sharePresentation(Project project){
        Presentation sharedPresentation = clonePresentation(this.original == null ? this : this.original);


        DataStorage.getInstance().presentation.lista.forEach(slide -> {
            slide.shareSlide(sharedPresentation);
            SwingUtilities.invokeLater(() -> {
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getJspLevi());
            });
        });

        project.addChild(sharedPresentation);
    }

    public Presentation clonePresentation(Presentation originalPresentation){
        Presentation clonePresentation = new Presentation(originalPresentation.name +"(clone)");

        clonePresentation.original = originalPresentation;
        if(originalPresentation.sharedPresentations == null) originalPresentation.sharedPresentations = new ArrayList<>();
        originalPresentation.sharedPresentations.add(clonePresentation);

        return clonePresentation;
    }

    @Override
    public void remove() {
        super.remove();
        if(sharedPresentations != null) sharedPresentations.forEach(Presentation::removeCopy);
    }

    protected void removeCopy(){
        super.remove();
    }
}
