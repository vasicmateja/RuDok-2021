package controller;


import DataStorage.DataStorage;
import model.RuNode;
import model.Slide;
import observerPackage.Observer;
import view.modelViews.SlideView;
import javax.swing.*;
import java.awt.event.MouseEvent;

public class SlideController {

    Observer<RuNode> observer = new Observer<RuNode>((value -> this.rerender())) ;
    SlideView slideView = new SlideView(this);
    Slide slide;

    public SlideController(){
        DataStorage.getInstance().observableTreeUpdate.subscribe(observer);
    }
    public JPanel render(int index){
        Slide slide = DataStorage.getInstance().slide;
        if(slide == null) {
            JPanel jPanel =  new JPanel();
            jPanel.add(new JLabel("Selektuj slide"));
            return jPanel;
        }
        return slideView.getImagePanel(slide, index);
    }

    public JPanel render(Slide slide, int index) {
        return slideView.getImagePanel(slide, index);
    }

    public void rerender(){

    }

    public void subscribe(Observer<MouseEvent> observer){
        slideView.mouseEventObservable.subscribe(observer);
    }
    public void subscribeToDrag(Observer<MouseEvent> observer){
        slideView.mouseDragged.subscribe(observer);
    }
}
