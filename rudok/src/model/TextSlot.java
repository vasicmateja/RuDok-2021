package model;

import java.awt.*;
import java.io.Serializable;

public class TextSlot extends Slot implements Serializable {

    String text ="Default";

    public TextSlot(int xcoordinate, int ycoordinate, int width, int height, Color color, SerializableStrokeAdapter stroke) {
        super(xcoordinate, ycoordinate, width, height, color, stroke);
    }

    public TextSlot(int xcoordinate, int ycoordinate, int width, int height, Color color, SerializableStrokeAdapter stroke, String text) {
        super(xcoordinate, ycoordinate, width, height, color, stroke);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
