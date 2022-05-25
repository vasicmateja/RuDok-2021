package view;

import controller.*;
import javax.swing.*;
import java.awt.event.MouseListener;

public class Menu extends JMenuBar {


    private final MouseListener NewProjectController = new NewButtonController() {
    };

    private final MouseListener RemoveController = new RemoveController();

    private final MouseListener  editPresentationController = new EditPresentationController();

    private final MouseListener changeStateController = new ChangeStateController();

    private final MouseListener saveProjectAction = new SaveProjectAction();

    private final MouseListener saveAllAction = new SaveAllAction();

     private final  MouseListener openProjectAction = new OpenProjectAction();


    public Menu(){
        JMenu file = new JMenu("File");
        file.setMnemonic('F');

        JMenu menuItemNew = new JMenu("New");
        menuItemNew.addMouseListener(NewProjectController);

        JMenu menuItemOpen = new JMenu("Open");
        menuItemOpen.addMouseListener(openProjectAction);

        JMenu menuItemSave = new JMenu("Save");
        menuItemSave.addMouseListener(saveProjectAction);

        JMenu menuItemSaveAll = new JMenu("SaveAll");
        menuItemSaveAll.addMouseListener(saveAllAction);


        file.add(menuItemNew);
        file.addSeparator();
        file.add(menuItemOpen);
        file.add(menuItemSave);
        file.add(menuItemSaveAll);

        JMenu help = new JMenu("Help");
        help.setMnemonic('H');
        JMenu menuItemEdit = new JMenu("Edit");
        menuItemEdit.addMouseListener(editPresentationController);
        MainFrame.getInstance();

        help.add(menuItemEdit);
        help.addSeparator();

        JMenu remove = new JMenu("Remove");
        remove.addMouseListener(RemoveController);

        JMenu state = new JMenu("SlideShow");
        state.addMouseListener(changeStateController);



        add(file);
        add(help);
        add(remove);
        add(state);
    }

}
