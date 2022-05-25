package state;

import model.Presentation;
import javax.swing.*;

public interface State {
    public void render(Presentation presentation, JComponent presentationPanel);
 }
