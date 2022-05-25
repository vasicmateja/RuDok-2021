package simpleFactory;


import view.Popups.PresentationFromChildJDialog;

public class ErrorPresentationFromChild implements Error{

    ErrorPresentationFromChild(){
        ErrorAction();
    }
    @Override
    public void ErrorAction() {
        PresentationFromChildJDialog er = new PresentationFromChildJDialog();
        er.setVisible(true);
    }
}
