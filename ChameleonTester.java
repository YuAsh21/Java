import javax.swing.*;

public class ChameleonTester{
	
	public static void main(String[] args){

		JFrame frame = new JFrame("Chameleon");
		frame.add(new ChameleonPanel());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}