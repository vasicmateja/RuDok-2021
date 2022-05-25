package model;

import java.awt.*;
import java.io.Serializable;

public class SerializableStrokeAdapter implements Serializable {

    double width;
    int cap;
    int join;
    float[] dash;

    public SerializableStrokeAdapter(double width, int cap, int join){
        super();
        this.width = width;
        this.cap = cap;
        this.join = join;
        this.dash = null;
    }

    public SerializableStrokeAdapter(double width, int cap, int join, float dash){
        this.width = width;
        this.cap = cap;
        this.join = join;
        this.dash = new float[] {dash};
    }

    public BasicStroke basicStroke(){
        if(dash == null){
            return new BasicStroke((float) width, cap, join);
        }
        return new BasicStroke((float) width, cap, join, 4, dash, 0);
    }
}
