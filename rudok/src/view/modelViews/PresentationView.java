package view.modelViews;

import DataStorage.DataStorage;
import controller.PresentationController;
import controller.SlideController;
import model.Presentation;
import model.RuNode;
import observerPackage.Observer;
import slotState.*;
import state.EditState;
import state.SlideShowState;
import state.State;
import view.Popups.ColorChooserJDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class PresentationView {

    JPanel presentationPanel = new JPanel();
    JPanel presentationPanelThumbnail;
    PresentationController controller;
    Presentation presentation;


    State state;
    EditState editState = new EditState();
    SlideShowState slideShowState = new SlideShowState();


    SlotState slotState;
    AddTextSlotState addTextSlotState = new AddTextSlotState();
    AddImageSlotState addImageSlotState = new AddImageSlotState();
    DeleteState deleteState = new DeleteState();
    MoveState moveState = new MoveState();
    EditSlotState editSlotState = new EditSlotState();

    public PresentationView(PresentationController presentationController){

        this.controller = presentationController;
        state= editState;
    }

    public PresentationView(Presentation presentation){
        this.presentation = presentation;
        state = editState;
    }


    public JPanel bigSlidePanel(Presentation presentation){
        this.subscribeToChange(presentation);
        DataStorage.getInstance().stateChange.subscribe(new Observer(state -> changeState((boolean)state)));
        Dimension min = new Dimension(500,200);
        presentationPanel.setMinimumSize(min);
        presentationPanel.setBackground(Color.darkGray);
        presentationPanel.setSize(500,500);
        generatePresPanel();

        return presentationPanel;
    }

    public void generatePresPanel(){
        JToolBar toolBar = new JToolBar();


        JButton jbColorChooser = new JButton("SlotOptions");
        jbColorChooser.setVisible(false);
        jbColorChooser.addActionListener(new ActionListener() {
            ColorChooserJDialog popupJdilog;

            @Override
            public void actionPerformed(ActionEvent e) {
                popupJdilog = new ColorChooserJDialog();
                popupJdilog.setVisible(true);
            }

            public  void  onConfirm(){
                popupJdilog.dispose();

                addTextSlotState.setWidth(Integer.parseInt(popupJdilog.getTfWidth().getText()));
                addTextSlotState.setHeight(Integer.parseInt(popupJdilog.getTfHeight().getText()));
                addTextSlotState.setColor(popupJdilog.getColorChooserJDialog().getColor());
            }

        });


        JButton jbAdd = new JButton("AddText");
        jbAdd.addActionListener(e ->{
            jbColorChooser.setVisible(true);
            setAddTextState();
        });

        JButton jbAddImage = new JButton("AddImage");
        jbAddImage.addActionListener(e ->{
            jbColorChooser.setVisible(true);
            setAddImageState();
        });

        JButton jbDelete = new JButton("Delete");
        jbDelete.addActionListener(e -> {
            jbColorChooser.setVisible(false);
            setDeleteState();
        });

        JButton jbMove = new JButton("Move");
        jbMove.addActionListener(e -> {
            jbColorChooser.setVisible(false);
            setMoveState();
        });


        JButton jbEditSlot = new JButton("Edit");
        jbEditSlot.addActionListener(e-> {
            jbColorChooser.setVisible(false);
            setEditSlotState();
        });


        toolBar.addSeparator();
        toolBar.add(jbColorChooser);
        toolBar.add(jbAdd);
        toolBar.add(jbAddImage);
        toolBar.add(jbDelete);
        toolBar.add(jbMove);
        toolBar.add(jbEditSlot);

        presentationPanel.add(toolBar, Component.TOP_ALIGNMENT);

        final SlideController controller = new SlideController();
        JPanel jPanel = controller.render(1);
        controller.subscribe(new Observer<>(e -> onMouseEvent((MouseEvent) e)));
        controller.subscribeToDrag(new Observer<>(e -> onMouseDragged((MouseEvent) e)));
        Dimension prefDim = new Dimension((int) (presentationPanel.getWidth()*0.7), (int) (presentationPanel.getHeight()*0.7));
        jPanel.setPreferredSize(prefDim);
        presentationPanel.add(jPanel, Component.CENTER_ALIGNMENT);

    }

    public JScrollPane initPresentationPanelThumbnail(){
        presentationPanelThumbnail = new JPanel();
        Dimension dim = new Dimension(110,500);
        presentationPanelThumbnail.setBackground(Color.CYAN);
        presentationPanelThumbnail.setPreferredSize(dim);
        return new JScrollPane(presentationPanelThumbnail);
    }

    public void getSlidesThumbnail(Presentation presentation){
        this.subscribeToChange(presentation);

        for (int i = 0; i < presentation.lista.size(); i++) {
            JPanel jPanel = new SlideController().render(presentation.lista.get(i), i + 1);
            jPanel.setPreferredSize(new Dimension(100, 100));


            presentationPanelThumbnail.add(jPanel);
        }
    }


    public void rerender(){
        if(presentationPanel != null) {
            presentationPanel.removeAll();
            this.generatePresPanel();
            SwingUtilities.invokeLater(() ->{
                presentationPanel.updateUI();
            });
        }
        if(presentationPanelThumbnail != null) {
            presentationPanelThumbnail.removeAll();
            getSlidesThumbnail((DataStorage.getInstance().presentation));
            SwingUtilities.invokeLater(()->{
                presentationPanelThumbnail.updateUI();
            });
        };
    }

    public void subscribeToChange(Presentation presentation){
        presentation.subscribe(new Observer<RuNode>(value -> rerender()));
    }


    public void changeState(Boolean state){
        if(!state) {
            this.setEditState();
        } else {
            this.setSlideShowState();
        }
    }

    private void setEditState(){
        this.state = this.editState;
        state.render(DataStorage.getInstance().presentation, presentationPanel);
    }

    private void setSlideShowState(){
        this.state = this.slideShowState;
        state.render(DataStorage.getInstance().presentation, presentationPanel);
    }

    private void setAddTextState(){
        this.slotState = this.addTextSlotState;
    }

    private void setAddImageState(){
        this.slotState = this.addImageSlotState;
    }

    private void setDeleteState(){
        this.slotState = this.deleteState;
    }

    private void setMoveState(){
        this.slotState = this.moveState;
    }

    private void setEditSlotState(){
        this.slotState = this.editSlotState;
    }

    void onMouseEvent(MouseEvent event) {
        if(slotState != null) {
            if (event.getID() == MouseEvent.MOUSE_PRESSED)
                this.slotState.mousePressed(DataStorage.getInstance().slide, event.getX(), event.getY());
            else if (event.getID() == MouseEvent.MOUSE_DRAGGED)
                this.slotState.mouseDragged(event.getX(), event.getY());
            else if (event.getID() == MouseEvent.MOUSE_RELEASED)
                this.slotState.mouseReleased(event.getX(), event.getY());
        }
    }

    void onMouseDragged(MouseEvent event){
        if(slotState != null) {
            this.slotState.mouseDragged(event.getX(), event.getY());
        }
    }



    private void subscribeToSlotChange(Presentation presentation){
      //  presentation.subscribeToSlotStage(new Observer<MouseEvent>((e) -> onPressedEvent((MouseEvent) e)));
    }
}
