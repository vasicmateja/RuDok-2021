package view;

import DataStorage.DataStorage;
import commandPatern.CommandManager;
import controller.ActionManager;
import controller.PresentationController;
import controller.ProjectController;
import controller.TreeController;
import model.WorkSpace;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance=null;
    Menu menu;
    Toolbar toolbar;
    JScrollPane jspLevi;
    private ActionManager actionManager;
    JTabbedPane jTabbedPane;
    TreeController treeController = new TreeController();
    JPanel proba = new JPanel();

    CommandManager commandManager = new CommandManager();

    private MainFrame(){

    }


    private void initalise() {
        setScreen();

        addMenu();
        actionManager = new ActionManager();
        addToolBar();

        WorkSpace workSpace = DataStorage.getInstance().workSpace;
        jspLevi = new JScrollPane(treeController.view.render());
        jspLevi.setBackground(Color.white);

        add(jspLevi);

        JSplitPane jspDesni = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jspDesni.setOneTouchExpandable(true);
        jspDesni.setLeftComponent(new PresentationController().renderLevi());
        jspDesni.setRightComponent(new ProjectController().render());
        jspDesni.setDividerLocation(120);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setOneTouchExpandable(true);
        splitPane.setLeftComponent(jspLevi);
        splitPane.setRightComponent(jspDesni);
        splitPane.setDividerLocation(160);

        add(splitPane);
    }

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
            instance.initalise();
        }
        return instance;
    }

    public ActionManager getActionManager(){

        return actionManager;
    }

    private void addMenu(){

        menu = new Menu();
        setJMenuBar(menu);
    }

    private void addToolBar(){
        toolbar = new Toolbar();
        add(toolbar, BorderLayout.NORTH);
    }

    private void setScreen(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/2, screenHeight/2);

        Image img = toolkit.getImage("view/images/iko.jpg");
        setIconImage(img);

        setTitle("Rudok");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JScrollPane getJspLevi() {
        return jspLevi;
    }

    public void setJspLevi(JScrollPane jspLevi) {
        this.jspLevi = jspLevi;
    }

    public JTabbedPane getjTabbedPane() {
        return jTabbedPane;
    }

    public void setjTabbedPane(JTabbedPane jTabbedPane) {
        this.jTabbedPane = jTabbedPane;
    }

    public CommandManager getCommandManager(){
        return commandManager;
    }
}
