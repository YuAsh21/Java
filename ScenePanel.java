import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
/**    A component that shows a scene composed of shapes. */
public class ScenePanel extends JPanel {
    private ArrayList < SceneShape > shapes;
    private Point mousePoint;
    private JButton houseButton, carButton, treeButton, removeButton;
    private JPanel buttonPanel;
    public ScenePanel() {
        shapes = new ArrayList < SceneShape > ();
        houseButton = new JButton("House");
        houseButton.addActionListener(new ShapeListener());
        carButton = new JButton("Car");
        carButton.addActionListener(new ShapeListener());
        treeButton = new JButton("Tree");
        treeButton.addActionListener(new ShapeListener());
        removeButton = new JButton("Remove");
        removeButton.addActionListener(new ShapeListener());
        buttonPanel = new JPanel();
        buttonPanel.add(houseButton);
        buttonPanel.add(carButton);
        buttonPanel.add(treeButton);
        buttonPanel.add(removeButton);
        add(buttonPanel, BorderLayout.NORTH);
        addMouseListener(new ShapeListener());
        addMouseMotionListener(new ShapeListener());
        setPreferredSize(new Dimension(300, 300));
    }
    /**       Adds a shape to the scene.       @param s the shape to add    */
    public void addShape(SceneShape s) {
        shapes.add(s);
        repaint();
    }

    /**       Removes all selected shapes from the scene.    */
    public void removeSelected() {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            SceneShape s = shapes.get(i);
            if (s.isSelected()) shapes.remove(i);
        }
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (SceneShape s: shapes) {
            s.draw(g2);
            if (s.isSelected()) s.drawSelection(g2);
        }
    }

     private class ShapeListener implements ActionListener, MouseListener, MouseMotionListener {
     public void actionPerformed(ActionEvent e) {
         if (e.getSource() == houseButton) addShape(new HouseShape(20, 20, 50));
         else if (e.getSource() == carButton) addShape(new CarShape(20, 20, 50));
         else if (e.getSource() == treeButton) addShape(new TreeShape(20, 20, 50));
         else if (e.getSource() == removeButton) removeSelected();
     }
     public void mousePressed(MouseEvent event) {
         mousePoint = event.getPoint();
         for (SceneShape s: shapes) {
             if (s.contains(mousePoint)) s.setSelected(!s.isSelected());
         }
         repaint();
     }
     public void mouseDragged(MouseEvent event) {
         Point lastMousePoint = mousePoint;
         mousePoint = event.getPoint();
         for (SceneShape s: shapes) {
             if (s.isSelected()) {
                 double dx = mousePoint.getX() - lastMousePoint.getX();
                 double dy = mousePoint.getY() - lastMousePoint.getY();
                 s.translate((int) dx, (int) dy);
             }
         }
         repaint();
     }
     public void mouseClicked(MouseEvent event) {};
     public void mouseReleased(MouseEvent event) {};
     public void mouseEntered(MouseEvent event) {};
     public void mouseExited(MouseEvent event) {};
     public void mouseMoved(MouseEvent event) {};
 }
 }