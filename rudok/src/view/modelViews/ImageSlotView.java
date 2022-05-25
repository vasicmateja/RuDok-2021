package view.modelViews;

import model.ImageSlot;
import model.Slot;
import javax.swing.*;
import java.awt.*;

public class ImageSlotView {

    ImageSlot slot;
    Image image;

    public ImageSlotView(ImageSlot slot) {
        this.slot = slot;
    }

    public void paint(Graphics2D g, JPanel parent){
        g.setColor(slot.getColor());
        g.setStroke((slot.getStroke()).basicStroke());
        g.drawRect(slot.getxCoordinate(), slot.getyCoordinate(), slot.getWidth(), slot.getHeight());
        image = Toolkit.getDefaultToolkit().getImage("D:\\Faks\\Dizajn softvera\\rudok-matejavasic8321rn\\rudok\\src\\view\\images\\random.jfif");
        g.drawImage(slot.getImage(), slot.getxCoordinate(), slot.getyCoordinate(), slot.getWidth(), slot.getHeight(), parent);
    }



    public Slot getSlot() {
        return slot;
    }
}
