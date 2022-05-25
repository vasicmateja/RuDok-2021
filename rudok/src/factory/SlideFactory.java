package factory;

import model.RuNode;
import model.Slide;

public class SlideFactory extends AbstractRuNodeFactory{
    @Override
    RuNode createNode(String text) {
        return new Slide(text);
    }
}
