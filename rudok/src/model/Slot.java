package model;

import java.awt.*;
import java.io.Serializable;

public abstract class Slot implements Serializable {

    int xCoordinate;
    int yCoordinate;

    int width;
    int height;

    Color color;
    SerializableStrokeAdapter stroke;


    public Slot(int xcoordinate, int ycoordinate, int width, int height, Color color, SerializableStrokeAdapter stroke) {
        xCoordinate = xcoordinate;
        yCoordinate = ycoordinate;
        this.width = width;
        this.height = height;
        this.color = color;
        this.stroke = new SerializableStrokeAdapter(4, BasicStroke.CAP_SQUARE, BasicStroke.CAP_SQUARE);
    }

    public boolean elementAt(int cursorX, int cursorY ){
        int slotX = this.xCoordinate;
        int slotY = this.yCoordinate;

        if((cursorX < ( slotX + this.width ) && cursorX > slotX) &&
                (cursorY < (slotY + this.height) && cursorY > slotY)) return true;

        return false;
    }


    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public SerializableStrokeAdapter getStroke() {
        return stroke;
    }

    public void setStroke(SerializableStrokeAdapter stroke) {
        this.stroke = stroke;
    }


}
