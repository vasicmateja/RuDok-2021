package controller;


public class ActionManager {

    private InfoAction infoAction;
    private NewAction newAction;
    private ShareAction shareAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private BoldAction boldAction;
    private UnderLineAction underLineAction;
    private ItalicAction italicAction;

    public ActionManager() {

        inicijalizujAkcije();
    }

    private void inicijalizujAkcije() {
        infoAction = new InfoAction();
        newAction = new NewAction();
        shareAction = new ShareAction();
        undoAction = new UndoAction();
        redoAction = new RedoAction();
        boldAction = new BoldAction();
        italicAction = new ItalicAction();
        underLineAction = new UnderLineAction();
    }

    public NewAction getNewAction() {
        return newAction;
    }

    public void setNewAction(NewAction newAction) {
        this.newAction = newAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public UndoAction getUndoAction(){
        return undoAction;
    }

    public RedoAction getRedoAction(){ return redoAction;}

    public BoldAction getBoldAction() {
        return boldAction;
    }

    public UnderLineAction getUnderLineAction() {
        return underLineAction;
    }

    public ItalicAction getItalicAction() {
        return italicAction;
    }

    public ShareAction getShareAction(){return shareAction;}
}
