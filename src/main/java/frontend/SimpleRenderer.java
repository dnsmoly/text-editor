package frontend;

import javax.swing.*;
import java.awt.*;

public class SimpleRenderer implements Renderer {
    private JFrame frame;

    @Override
    public void renderMainFrame() {
        frame = new JFrame("My Drawing");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
//        frame.getContentPane().add(new JLabel("Hello"), BorderLayout.AFTER_LAST_LINE);
//        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void renderEditorFrame() {
        int fontHeight = frame.getGraphics().getFontMetrics().getHeight();
        //TODO:
        // 1. Split project ot MVC
        // 2. Think about controller. What are listeners? How to implement them? Do I even need them??
        // 1. figure ot how to create a text area and split it to lines
        // 2. render lines
        // 3. figure out scrolling
    }
}
