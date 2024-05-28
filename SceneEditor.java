import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
/**    A program that allows users to edit a scene composed    of items. */
public class SceneEditor {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new ScenePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}