package controller;

import DataStorage.DataStorage;
import model.Presentation;
import model.RuNode;
import model.Slide;
import observerPackage.Observer;
import view.modelViews.PresentationView;

import javax.swing.*;

    public class PresentationController {
        Observer<RuNode> observerTreeUpdate = new Observer<RuNode>((value -> this.rerender())) ;
        Observer<RuNode> observerPresViewUpdate = new Observer<RuNode>((value -> { if(value instanceof Slide) this.rerender(); })) ;
        PresentationView presentationView = new PresentationView(this);

    public PresentationController(){
         DataStorage.getInstance().observableTreeUpdate.subscribe(observerTreeUpdate);
         DataStorage.getInstance().selectedNodeChange.subscribe(observerPresViewUpdate);
    }

    public JPanel renderDesni(){
        Presentation presentation = DataStorage.getInstance().presentation;
        return presentationView.bigSlidePanel(presentation);
    }

    public JScrollPane renderLevi(){
        Presentation presentation = DataStorage.getInstance().presentation;
        JScrollPane scrollPane = presentationView.initPresentationPanelThumbnail();
        presentationView.getSlidesThumbnail(presentation);
        return scrollPane;
    }

    public void rerender(){
        presentationView.rerender();
    }
}
