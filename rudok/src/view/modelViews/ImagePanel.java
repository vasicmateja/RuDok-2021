package view.modelViews;

import model.ImageSlot;
import model.Slide;
import model.TextSlot;
import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel{

    private Image image;
    private TextSlotView textSlotView;
    private ImageSlotView imageSlotView;
    private Slide slide;

    public ImagePanel(Slide slide){
        this.slide = slide;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
                this.image = toolkit.getImage(slide.getThemePath());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0 ,0,this.getWidth(),this.getHeight(), this);
        slide.getSlots().forEach(slot -> {
            if(slot instanceof TextSlot){
                textSlotView = new TextSlotView((TextSlot) slot);
                textSlotView.paint((Graphics2D) g, this);
            }else if (slot instanceof ImageSlot){
                imageSlotView = new ImageSlotView((ImageSlot) slot);
                imageSlotView.paint((Graphics2D) g, this);
            }
        });

    }

    public void setSize(Dimension dimension){
        super.setSize(dimension);
        this.paintComponent(this.image.getGraphics());
    }
}
