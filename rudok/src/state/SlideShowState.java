package state;


import DataStorage.DataStorage;
import controller.SlideController;
import model.Presentation;
import model.Slide;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SlideShowState implements State{

    JPanel jPanel = new JPanel();
    CardLayout cardLayout = new CardLayout();

    @Override
    public void render(Presentation presentation, JComponent presentationPanel) {
        presentationPanel.removeAll();
        jPanel.setLayout(cardLayout);
        presentationPanel.setLayout(new BoxLayout(presentationPanel, BoxLayout.Y_AXIS));
        JButton jButtonPrev = new JButton("<");
        JButton jButtonNext = new JButton(">");

        List<Slide> slides = DataStorage.getInstance().presentation.lista;
        int i = 0;
        for(Slide slide : slides){
            JPanel slideView = new SlideController().render(slide, ++i);
            slideView.setPreferredSize(new Dimension(500,500));
            jPanel.add(slideView);
        }


        JPanel jPanel1 = new JPanel();
        jPanel1.add(jButtonPrev);
        jPanel1.add(jButtonNext);
        presentationPanel.add(jPanel1);
        presentationPanel.add(jPanel);

        jButtonPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(jPanel);
                jPanel.repaint();
                jPanel.revalidate();
                presentationPanel.repaint();
                presentationPanel.revalidate();
            }
        });


        jButtonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(jPanel);
                jPanel.repaint();
                jPanel.revalidate();
                presentationPanel.repaint();
                presentationPanel.revalidate();
            }
        });

        SwingUtilities.invokeLater(() -> {
            presentationPanel.updateUI();
        });
    }
}
