package view.modelViews;

import model.SerializableStrokeAdapter;
import model.Slot;
import model.TextSlot;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class TextSlotView {
    TextSlot slot;

    public TextSlotView(TextSlot slot) {
        this.slot = slot;
    }

    public void paint(Graphics2D g, JPanel parent){
        g.setColor(slot.getColor());
        g.setStroke((slot.getStroke()).basicStroke());
        g.drawRect(slot.getxCoordinate(), slot.getyCoordinate(), slot.getWidth(), slot.getHeight());
        g.drawString(slot.getText(), slot.getxCoordinate()+30, slot.getyCoordinate()+50);
        }



    public Slot getSlot() {
        return slot;
    }
}
