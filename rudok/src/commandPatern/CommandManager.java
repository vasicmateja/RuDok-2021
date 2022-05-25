package commandPatern;

import view.MainFrame;

import java.util.ArrayList;

public class CommandManager {

    ArrayList<Command> commands = new ArrayList<>();
    private int currCommand = 0;

    public void addCommand(Command command){
        while(currCommand < commands.size())
            commands.remove(currCommand);
        commands.add(command);
        doCommand();
    }


    public void doCommand(){
        if(currCommand < commands.size()){
            commands.get(currCommand++).doCommand();
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
        }
        if(currCommand==commands.size()){
           MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
        }
    }

    public void undoCommand(){
        if(currCommand > 0){
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
            commands.get(--currCommand).undoCommand();
        }
        if(currCommand==0){
           MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
        }
    }
}
