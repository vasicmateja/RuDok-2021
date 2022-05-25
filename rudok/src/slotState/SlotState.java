package slotState;

import model.Slide;

public abstract class SlotState {

    public void mousePressed(Slide currSlide, int cursorX, int cursorY){}

    public void mouseReleased(int cursorX, int cursorY){}

    public void mouseDragged(int cursorX, int cursorY){}
}
