package simpleFactory;

public class ErrorFactory {

    public ErrorFactory(){

    }

    public static Error createError(String errorType){
        if(errorType.toLowerCase().equals("izparentaslide")){
            return new ErrorSlideFromParent();
        }
        if(errorType.toLowerCase().equals("izchildaprezentacija")){
            return new ErrorPresentationFromChild();
        }
        if(errorType.toLowerCase().equals("slotpopupgreska")){
            return  new ErrorSlotPopup();
        }
        return null;
    }
}
