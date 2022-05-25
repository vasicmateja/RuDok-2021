package factory;

import model.Presentation;
import model.RuNode;

public class PresentationFactory extends AbstractRuNodeFactory{
    @Override
    RuNode createNode(String text) {
        return new Presentation(text);
    }
}
