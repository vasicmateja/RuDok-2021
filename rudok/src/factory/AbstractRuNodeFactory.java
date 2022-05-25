package factory;

import DataStorage.DataStorage;
import model.*;

public abstract class AbstractRuNodeFactory {

    public static class Builder{

        public RuNode build (String text, RuNodeComp selected){

            if(selected instanceof WorkSpace || selected == null){
                return new ProjectFactory().createNode(text);
            }

            if(DataStorage.getInstance().selected instanceof Project){
                return new PresentationFactory().createNode(text);
            }

            if (DataStorage.getInstance().selected instanceof Presentation){
                return new SlideFactory().createNode(text);
            }

            return null;
        }
    }

    abstract  RuNode createNode(String text);
}
