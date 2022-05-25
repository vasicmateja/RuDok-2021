package controller;

import DataStorage.DataStorage;
import view.Popups.SharePopup;
import java.awt.event.ActionEvent;

public class ShareAction extends AbstractRudokAction{

    public ShareAction(){
        putValue(SMALL_ICON, loadIcon("D:\\Faks\\Dizajn softvera\\rudok-matejavasic8321rn\\rudok\\src\\view\\images\\share.png"));
        putValue(NAME, "Share");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SharePopup sharePopup = new SharePopup(DataStorage.getInstance().presentation);
        sharePopup.setVisible(true);
    }
}
