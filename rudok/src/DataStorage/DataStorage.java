package DataStorage;


import model.*;
import observerPackage.Observable;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {

    private static DataStorage instance = null;
    public WorkSpace workSpace;
    public Project project;
    public Presentation presentation;
    public Slide slide;
    public DefaultMutableTreeNode selectedTreeNode;
    public List<RuNode> nodes = new ArrayList<RuNode>();
    public RuNode selected;
    public Observable<RuNode> observableTreeUpdate = new Observable<>();
    public Observable<RuNode> selectedNodeChange = new Observable<>();

    public Observable<Boolean> stateChange = new Observable<>();

    private DataStorage(){

    }

    private void initialize(){
        this.workSpace = new WorkSpace("Workspace");
        this.selectedTreeNode = this.workSpace.treeNode;
        this.project = new Project("Project 1");
        this.presentation = new Presentation("Presentation 1");
        this.slide = new Slide("Slide");
        this.presentation.addSlide(this.slide);
        this.project.addPresentation(this.presentation);
        this.workSpace.addProject(this.project);
    }

    public static DataStorage getInstance(){
        if(instance == null){
            instance = new DataStorage();
            instance.initialize();
        }

        return instance;
    }

    public void setSelectedTreeNode(RuNode node){
        this.selected = node;
        if(selected instanceof Project) project = (Project) selected;
        if(selected instanceof Presentation) presentation = (Presentation) selected;
        if(selected instanceof Slide) slide = (Slide) selected;
        this.selectedNodeChange.next(node);
    };


}
