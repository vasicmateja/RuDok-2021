package model;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.Serializable;

public class CustomTreeRuNode extends DefaultMutableTreeNode implements Serializable {

    public  CustomTreeRuNode(RuNode ruNode){
        super(ruNode.name);
    }

    public void addNewRuNode(CustomTreeRuNode node){
        this.add(node);
    }
}
