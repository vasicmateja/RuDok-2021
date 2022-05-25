package simpleFactory;

import view.Popups.JDialogErrorSlotPopup;

public class ErrorSlotPopup implements Error{

    ErrorSlotPopup(){
        ErrorAction();
    }
    @Override
    public void ErrorAction() {
        JDialogErrorSlotPopup errorSlotPup = new JDialogErrorSlotPopup();
        errorSlotPup.setVisible(true);
    }
}
