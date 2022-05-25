package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class RuNodeComp<childType extends RuNode> extends RuNode implements Serializable {

    public  List<childType> lista= new ArrayList<childType>();

    public RuNodeComp(String name) {
        super(name);
    }

    public void addChild(childType child){
        if(lista.isEmpty()){
            lista = new ArrayList<childType>();
        }
        lista.add(child);
        this.treeNode.addNewRuNode(child.treeNode);
        child.parent = this;
        this.onChangeTrigger();
    }

   public void removeChild(childType child){
        lista.remove(child);
        this.onChangeTrigger();
    }

    public childType findChild(String name){

        Optional<childType> node = lista.stream().filter(n -> n.name == name).findFirst();

        return node.get();
    }

    public abstract void addNewChild(childType child);
}
