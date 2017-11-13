import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ice cream controller class
 * @author Xijie Guo
 *
 */
@SuppressWarnings("serial")
public class IceCreamMaker extends JPanel implements ActionListener
{
	public IceCreamCone cone;

	private IceCreamConeView coneView;
	
	//JButton array with size 4
	private JButton[] flavorBtns = new JButton[4];
	
	//a trash button
	private JButton trashButton = new JButton("Trash the top scoop !");
	
	//Button for random flavor of the scoop
	private JButton randomButton;
	
	public IceCreamMaker() {
		super(new BorderLayout());

		cone = new IceCreamCone();

		coneView = new IceCreamConeView(cone);

		addMenu();
		add(coneView, BorderLayout.CENTER);
		
	}
	
	/**
	 * Create 4 flavor buttons and return the panel 
	 * @return the panel containing 4 flavor buttons
	 */
	private JPanel createFlavorMenu() {
		JPanel flavorPanel = new JPanel();
		for(int i = 0; i < flavorBtns.length; i++) {
			flavorBtns[i] = new JButton(IceCreamCone.FLAVORS[i]);
			flavorBtns[i].setBackground(IceCreamConeView.PAINT_COLORS[i]);
			flavorBtns[i].setOpaque(true);
			flavorBtns[i].setBorderPainted(false);
			flavorPanel.add(flavorBtns[i]);
			flavorBtns[i].addActionListener(this);
		}
		flavorPanel.setLayout(new GridLayout(1,4));

		return flavorPanel;
 	}
	
	/**
	 * Create a trash button
	 * @return the trash button
	 */
	private JButton createTrashButton() {
		trashButton.addActionListener(this);
		return trashButton;
	}
	
	/**
	 * Add flavor buttons and trash buttons together to make a menu and place the menu on the top of the frame
	 */
	private void addMenu() {
		JPanel menuPanel = new JPanel();
		JPanel trashPanel = new JPanel();

		trashPanel.add(createTrashButton());
		trashPanel.setLayout(new GridLayout(1, 1));

		menuPanel.add(createFlavorMenu());
		menuPanel.add(trashPanel);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		add(menuPanel, BorderLayout.NORTH);
	}
	
	/**
	 * implements activities related to JButtons
	 */
	public void actionPerformed(ActionEvent e) {
		
		JButton src = (JButton) e.getSource();

		for(int i = 0; i < flavorBtns.length; i++) {
			if(src == flavorBtns[i]) {
				cone.addScoop(IceCreamCone.FLAVORS[i]);
			}
		}
		
		if(src == trashButton) {
			//Delete the top scoop
			cone.popTopScoop();
		}

		else if(src == randomButton) {
			//Add the random flavor scoop
			cone.addScoop();
		}
		repaint();
	}
	
}
