package slotState;

import model.Slide;
import model.Slot;
import java.util.concurrent.atomic.AtomicReference;

public class DeleteState extends SlotState{

    @Override
    public void mousePressed(Slide currSlide, int cursorX, int cursorY) {

        AtomicReference<Slot> foundSlot = new AtomicReference<>();
        currSlide.getSlots().forEach(slot -> {if(slot.elementAt(cursorX, cursorY)) foundSlot.set(slot);});
        if(foundSlot != null) currSlide.removeSlot(foundSlot.get());

    }
}
