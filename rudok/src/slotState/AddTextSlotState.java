package slotState;

import model.SerializableStrokeAdapter;
import model.Slide;
import model.TextSlot;
import java.awt.*;


public class AddTextSlotState extends SlotState{

    int width = 100;
    int height = 100;
    Color color = Color.gray;
    SerializableStrokeAdapter stroke = new SerializableStrokeAdapter(4, BasicStroke.CAP_SQUARE, BasicStroke.CAP_SQUARE);

    @Override
    public void mousePressed(Slide currSlide, int x, int y) {
        TextSlot slot = new TextSlot(x, y, width ,height, color, stroke);
        currSlide.addSlot(slot);

    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setStroke(SerializableStrokeAdapter stroke) {
        this.stroke = stroke;
    }
}
