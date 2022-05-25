package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Slide extends  RuNode implements Serializable {

    String themePath = "D:\\Faks\\Dizajn softvera\\rudok-matejavasic8321rn\\rudok\\src\\view\\images\\theme1.jpeg";
    int index;
    Slide original;
    ArrayList<Slide> sharedSlides;

    List<Slot> slots = new ArrayList<>();

    public Slide(String name){
        super(name);
    }

    public  Slide(String name, String themePath){
        super(name);
        this.themePath = themePath;
    }

    public Slide(String name, String themePath, int index){
        super(name);
        this.themePath = themePath;
        this.index = index;
    }

    public void shareSlide(Presentation presentation){
        Slide sharedSlide = cloneSlides(this.original == null ? this : this.original);
        presentation.addChild(sharedSlide);
    }

    public Slide cloneSlides(Slide originalSlide){
        Slide cloneSlide = new Slide(originalSlide.name +"(clone)");

        originalSlide.slots.forEach(cloneSlide::addSlot);
        cloneSlide.original = originalSlide;
        if(originalSlide.sharedSlides == null) originalSlide.sharedSlides = new ArrayList<>();
        originalSlide.sharedSlides.add(cloneSlide);

        return cloneSlide;
    }

    public String getThemePath(){
        return themePath;
    }

    public int getIndex(){
        return index;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void removeSlot(Slot slot){
        this.slots.remove(slot);
        this.onChangeTrigger();
        if(sharedSlides != null) sharedSlides.forEach(Slide::removeCopy);
    }

    public void addSlot(Slot slot){
        slots.add(slot);
        this.onChangeTrigger();
    }

    public void trigger(){
        this.onChangeTrigger();
    }

    protected void removeCopy(){
        super.remove();
    }

    @Override
    public void remove() {
        super.remove();
        if(sharedSlides != null) sharedSlides.forEach(Slide::removeCopy);
    }
}

