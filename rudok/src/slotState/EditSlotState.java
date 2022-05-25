package slotState;

import DataStorage.DataStorage;
import model.ImageSlot;
import model.Slide;
import model.Slot;
import model.TextSlot;
import view.Popups.TextSlotEditPopup;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class EditSlotState extends SlotState{

    Slot selectedSlot;
    TextSlotEditPopup textSlotEditPopup;
    JFileChooser jFileChooser;

    @Override
    public void mousePressed(Slide currSlide, int cursorX, int cursorY) {
        currSlide.getSlots().forEach(slot -> {
            if(slot.elementAt(cursorX,cursorY)){
                selectedSlot = slot;
                if(selectedSlot instanceof TextSlot) {
                    textSlotEditPopup = new TextSlotEditPopup((TextSlot) selectedSlot);
                    textSlotEditPopup.setVisible(true);
                }
                if ( selectedSlot instanceof ImageSlot){
                    jFileChooser = new JFileChooser();

                    jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
                    int returnVal = jFileChooser.showDialog(new JDialog(), "Select image");
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = jFileChooser.getSelectedFile();
                        String imagePath = file.getPath();
                        ImageSlot imageSlot = (ImageSlot) slot;
                        imageSlot.setImage(Toolkit.getDefaultToolkit().getImage(imagePath));
                        DataStorage.getInstance().slide.trigger();
                    } else {
                        System.out.print("Cancelled");
                    }
                }
            }


        });
    }
}
