package slotState;

import DataStorage.DataStorage;
import model.Slide;
import model.Slot;

public class MoveState extends SlotState{

    Slot selectedSlot;

    @Override
    public void mousePressed(Slide currSlide, int cursorX, int cursorY) {
        currSlide.getSlots().forEach(slot -> {
            if(slot.elementAt(cursorX,cursorY)){
                selectedSlot = slot;
            }
        });
    }

    @Override
    public void mouseDragged(int cursorX, int cursorY) {
        if(selectedSlot != null) {
            selectedSlot.setxCoordinate(cursorX);
            selectedSlot.setyCoordinate(cursorY);
            DataStorage.getInstance().slide.trigger();
        }
    }

    @Override
    public void mouseReleased(int cursorX, int cursorY) {
        selectedSlot = null;
        DataStorage.getInstance().slide.trigger();

    }
}
