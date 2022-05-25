package model;

import java.awt.*;
import java.io.Serializable;

public class ImageSlot extends Slot implements Serializable {

    Image image;

    public ImageSlot(int xcoordinate, int ycoordinate, int width, int height, Color color, SerializableStrokeAdapter stroke) {
        super(xcoordinate, ycoordinate, width, height, color, stroke);
    }

    public ImageSlot(int xcoordinate, int ycoordinate, int width, int height, Color color, SerializableStrokeAdapter stroke,Image image) {
        super(xcoordinate, ycoordinate, width, height, color, stroke);
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
