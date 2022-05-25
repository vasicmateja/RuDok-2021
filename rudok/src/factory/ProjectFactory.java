package factory;

import model.Project;
import model.RuNode;

public class ProjectFactory extends AbstractRuNodeFactory{
    @Override
    RuNode createNode(String text) {
        return new Project(text);
    }
}
