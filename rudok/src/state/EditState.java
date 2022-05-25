package state;

import model.Presentation;
import view.modelViews.PresentationView;
import javax.swing.*;

public class EditState implements State {

    @Override
    public void render(Presentation presentation, JComponent presentationPanel) {
        presentationPanel.removeAll();

        PresentationView presentationView = new PresentationView(presentation);
        presentationPanel.add(presentationView.bigSlidePanel(presentation));


        SwingUtilities.invokeLater(() -> {
            presentationPanel.updateUI();
        });

    }
}
