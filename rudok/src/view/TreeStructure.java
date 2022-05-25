package view;

import DataStorage.DataStorage;
import controller.TreeController;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;


public class TreeStructure {

    JTree tree;
    DefaultMutableTreeNode root;
    TreeSelectionListener treeSelectionListener;
    TreeController controller;
    MouseListener treeMouseListener;


    public TreeStructure(TreeController controller){
        this.controller = controller;
        root = DataStorage.getInstance().workSpace.treeNode;
    }


    public JTree render(){
        tree = new JTree(root);
        addTreeSelectionListener();
        return tree;
    }

    public TreeSelectionListener getTreeSelectionListener() {
        return treeSelectionListener;
    }

    public void setTreeSelectionListener(TreeSelectionListener treeSelectionListener) {
        this.treeSelectionListener = treeSelectionListener;
    }

    private void addTreeSelectionListener(){
        tree.addTreeSelectionListener(treeSelectionListener -> {
            List <String> lista = parsePath(treeSelectionListener);
            if(lista == null){}
            this.controller.onEvent(lista);
        });

    }


    private List<String> parsePath(TreeSelectionEvent event) {
        TreePath path = event.getNewLeadSelectionPath();
        if(path == null) {
            return null;
        }
        return Arrays.stream(path.getPath()).map(t -> t.toString()).toList();
    }

}
