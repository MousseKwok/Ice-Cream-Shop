import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * 
 * @author Xijie Guo
 *
 */
@SuppressWarnings("serial")
public class IceCreamLineManager extends JPanel implements ActionListener {
	private IceCreamLine line;
	
	private JButton orderButton;

	private JButton serveButton;
	
	public IceCreamLineManager() {
		super(new BorderLayout());
		//Add the panel holding two buttons
		addControls();
		line = new IceCreamLine();
		add(line, BorderLayout.CENTER);
        
	}
	
	/**
	 * Create the panel to hold two buttons and add the panel to the north of the frame
	 */
	public void addControls() {
		JPanel panel = new JPanel();
		panel.add(createNewOrderButton());
		panel.add(createRemoveNextButton());
		panel.setLayout(new GridLayout(2, 1));
		add(panel, BorderLayout.NORTH);
   }
	
	/**
	 * Create the order button
	 * @return the order button
	 */
	private JButton createNewOrderButton() {
		orderButton = new JButton("Add a random order");
		orderButton.setAlignmentX(CENTER_ALIGNMENT);
		orderButton.addActionListener(this);
		return orderButton;
	}
	
	/**
	 * Create the serve button
	 * @return the serve button
	 */
	private JButton createRemoveNextButton() {
		serveButton = new JButton("Serve the next order");
		serveButton.setAlignmentX(CENTER_ALIGNMENT);
		serveButton.addActionListener(this);
		return serveButton;
	}

	/**
	 * Interact with JComponents
	 */
	public void actionPerformed(ActionEvent e) {
		//Decide which button we are interacting with
		JButton src = (JButton) e.getSource();
		if(src == orderButton) {
			//Add a random order
			line.addRandomOrder();
			//Refresh display
		}
		
		else if(src == serveButton) {
			//Remove the current order and get the next order
			line.removeRandomOrder();
		}
                validate();
                repaint();
	}
}
