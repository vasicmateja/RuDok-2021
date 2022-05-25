package controller;

import javax.swing.*;


public abstract class AbstractRudokAction extends AbstractAction {

    public Icon loadIcon(String iconPath){
        ImageIcon icon = new ImageIcon(iconPath);
        return icon;
    }
}
