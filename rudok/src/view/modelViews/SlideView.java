package view.modelViews;


import controller.MouseController;
import controller.SlideController;
import model.Slide;
import observerPackage.Observable;
import observerPackage.Observer;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SlideView{

    JPanel jPanel = new JPanel();
    Slide slide;
    SlideController controller;
    ImagePanel imagePanel;
    public Observable<MouseEvent> mouseEventObservable = new Observable<>();
    public Observable<MouseEvent> mouseDragged = new Observable<>();

    public SlideView(SlideController slideController){
        this.controller = slideController;
    }
    public SlideView(Slide slide){
        this.slide = slide;
    }

    public ImagePanel getImagePanel(Slide slide, int index){
        imagePanel = new ImagePanel(slide);
        imagePanel.setSize(500,500);
        JLabel slideNum = new JLabel("Slide br: " + index );
        imagePanel.add(slideNum);
        imagePanel.addMouseListener(new MouseController() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseEventObservable.next(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseEventObservable.next(e);
            }
        });

        imagePanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mouseDragged.next(e);
            }
        });

        slide.subscribe(new Observer<>(value -> this.rerender()));

        return imagePanel;
    }



    public void rerender() {
        SwingUtilities.invokeLater(() -> {
            imagePanel.repaint();
        });
    }

}
