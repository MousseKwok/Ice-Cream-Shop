import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class IceCreamShop extends JPanel implements ActionListener{
	//Score the users win if they served the right order 
	public static final int CORRECT_MATCH_SCORE = 10;
	
	//Score the users lose if they served the wrong order
	public static final int INCORRECT_MATCH_SCORE = 5;
	
	//Instructions of this game
	public static final String INSTRUCTIONS = "<html>Make the ice cream cones to match the next order(at the top)<br>"
			+ "Every correct order served earns you 10 points<br>"
			+ "Make the wrong cone and you'll lose 5 points</html>";
			                               
	private IceCreamLine line;
	
	private IceCreamMaker maker;
	
	private int score = 0;
	
	private JLabel scoreLabel;
	
	//Button for serving the next order
	private JButton serveNext;
	
	//Button for adding a random order
	private JButton addRandom;
	
	public IceCreamShop() {
		super(new BorderLayout());
	
		line = new IceCreamLine();
		
		maker = new IceCreamMaker();

		add(createTopArea(), BorderLayout.NORTH);
	   
		add(createAddRandom(), BorderLayout.WEST);
		
		add(maker, BorderLayout.CENTER);
	}
	
	/**
	 * Create a panel holding instruction, score label and serve button
	 * @return the panel
	 */
	private JPanel createTopArea() {
		JLabel instruction = new JLabel(INSTRUCTIONS);
		JPanel stringPanel = new JPanel();
		stringPanel.add(instruction);
		scoreLabel = new JLabel("Score : " + score);
		
		JPanel scorePanel = new JPanel();
		scorePanel.add(scoreLabel);
		serveNext = new JButton("Serve the next order");
		serveNext.addActionListener(this);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(serveNext);
		buttonPanel.setLayout(new GridLayout(1, 1));
		
		JPanel panel = new JPanel();
		panel.add(stringPanel);
		panel.add(scorePanel);
		panel.add(buttonPanel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		return panel;
	}
	
	/**
	 * Create a JPanel that holds the button for adding random flavor and the button for serving the order
	 * @return the JPanel
	 */
	private JPanel createAddRandom() {
		JPanel linePanel = new JPanel();
		linePanel.setLayout(new BoxLayout(linePanel, BoxLayout.Y_AXIS));
		addRandom = new JButton("Add the random order");
		addRandom.addActionListener(this);
		linePanel.add(addRandom);
		linePanel.add(line);
		return linePanel;
	}
	
	/**
	 * Interacting with buttons
	 */
	public void actionPerformed(ActionEvent e) {
		//Decide which button we are interacting with
	    JButton src = (JButton) e.getSource();
	    
	    if(src == addRandom) {
	    	//Add a random order
	    	line.addRandomOrder();
	    }
	    
	   else if(src == serveNext) {
	    	if(line.hasOrder()) {
	    		updateScore();
	    		//Remove order in the ice cream line area
	    		line.removeRandomOrder();
	    		//Remove order in the ice cream maker area
		    	maker.cone.popScoops();
	    	}
	    }
	   validate();
	   repaint();
	}
	
	/**
	 * Update score 
	 */
	private void updateScore() {
		//Check if the generated order matches the the order the user created
		if(matches()) {
			//Increase score by 10
			score += CORRECT_MATCH_SCORE;
		}
		else {
			//Decrease score by 5
			score -= INCORRECT_MATCH_SCORE;
		}
		scoreLabel.setText("Score : " + score);
	}
	
	/**
	 * Compare if the generated random ice cream is the same as the ice cream the user made 
	 * @return true if they are the same
	 */
	private boolean matches() {
		Stack<Integer> makerStack = maker.cone.getScoopFlavorStack();
		Stack<Integer> lineStack = line.getOrder().getScoopFlavorStack();
		
		if(makerStack.size() != lineStack.size()) {
			return false;
		}
		
		while(!lineStack.isEmpty()) {
			
			if(makerStack.pop() != lineStack.pop()) {
				return false;
			}
		}
		
		//If they are all the same, return true
		return true;
	}
}
