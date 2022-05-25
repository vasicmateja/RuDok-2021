package controller;

import view.Popups.InfoJDialog;

import java.awt.event.ActionEvent;

public class InfoAction extends AbstractRudokAction{

    public InfoAction(){
        putValue(SMALL_ICON, loadIcon("D:\\Faks\\Dizajn softvera\\rudok-matejavasic8321rn\\rudok\\src\\view\\images\\Info.png"));
        putValue(NAME,"Info");
        putValue(SHORT_DESCRIPTION, "Info o studentu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InfoJDialog jDialog = new InfoJDialog();
        jDialog.setVisible(true);
    }
}
