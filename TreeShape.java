import java.awt.*;
import java.awt.geom.*;

public class TreeShape extends CompoundShape{

	public TreeShape(int x, int y, int width){

		Ellipse2D.Double head = new Ellipse2D.Double(x, y, width / 1.5, width / 1.5);

		Rectangle2D.Double body = new Rectangle2D.Double(x + width / 9, y + width / 2, width / 3, width / 3);

		add(head);
		add(body);


	}



}