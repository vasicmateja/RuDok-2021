package model;


import observerPackage.Observable;
import observerPackage.Observer;
import java.io.Serializable;

public class RuNode implements Serializable {
    protected String name;
    public RuNodeComp parent;
    public CustomTreeRuNode treeNode;

    transient protected Observable<RuNode> onChange = new Observable<>();

   RuNode(String name){
        this.name = name;
        this.treeNode = new CustomTreeRuNode(this);
    }

   RuNode(String name, RuNodeComp parent){
        this.name = name;
        this.parent = parent;
        this.treeNode = new CustomTreeRuNode(this);
    }

    public void subscribe (Observer<RuNode> observer){
       this.onChange.subscribe(observer);
    }

    protected void onChangeTrigger(){
        this.onChange.next(this);
    }

    public String getName() {
        return name;
    }

    public void  remove(){
        this.treeNode.removeFromParent();
        this.parent.removeChild(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public RuNodeComp getParent() {
        return parent;
    }

    public void setParent(RuNodeComp parent) {
        this.parent = parent;
    }
}
