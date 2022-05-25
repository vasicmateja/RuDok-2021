package simpleFactory;

import view.Popups.SlideFromParentJDialog;

public class ErrorSlideFromParent implements Error{

    ErrorSlideFromParent(){
        ErrorAction();
    }
    @Override
    public void ErrorAction() {
        SlideFromParentJDialog er = new SlideFromParentJDialog();
        er.setVisible(true);
    }
}
