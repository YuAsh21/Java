import java.awt.*;
import java.awt.geom.*;
/**    A shape that manages its selection state. */
public abstract class SceneShape implements SelectableShape {
    private boolean selected;
    public void setSelected(boolean b) {
        selected = b;
    }
    public boolean isSelected() {
        return selected;
    }
    public void drawSelection(Graphics2D g2) {
        g2.setColor(Color.MAGENTA);
        draw(g2); //abstract method from SelectableShape  
        g2.setColor(Color.BLACK); //reset    }  
        /*Method draw is not defined here.       
        It is to be defined by the concrete classes        
        that inherit from SceneShape.    
        */
    }

}