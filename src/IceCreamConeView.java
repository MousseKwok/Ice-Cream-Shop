import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * Display the view for ice cream cone
 * @author Xijie Guo
 *
 */
@SuppressWarnings("serial")
public class IceCreamConeView extends JComponent{
	//Color array of 4 colors of different flavors
	public static final Color[] PAINT_COLORS = {Color.white, Color.pink, new Color(152, 251, 152), Color.orange};
	
	//Size of ice cream cone
	public static final int CONE_WIDTH = 30;
	public static final int CONE_HEIGHT = 60;
	
	//Size of scoop
	public static final int SCOOP_DIAMETER = 40;
	
	//Overlapped length
	public static final int SCOOP_OVERLAP = 8;
	
	//Temporary stack of ice cream
	private StackLL<Integer> tempStack = new StackLL<Integer>();

	private IceCreamCone cone;
	
	public IceCreamConeView(IceCreamCone cone) {
		this.cone = cone;
	}
	
	/**
	 * Paint cone and scoops
	 */
	public void paint(Graphics g) {
		//Paint the ice cream cone and ice cream scoops
		paintCone(g);
		paintScoops(g);
	}
	
	/**
	 * Paint the ice cream cone
	 * @param g for Graphics object
	 */
	private void paintCone(Graphics g) {
		
		int[] xPoints = {getWidth()/2, (getWidth()-CONE_WIDTH)/2, (getWidth()-CONE_WIDTH)/2+CONE_WIDTH};
		
		int[] yPoints = {getHeight(), getHeight() - CONE_HEIGHT, getHeight() - CONE_HEIGHT};
		g.setColor(new Color(240,220,130));
		g.fillPolygon(xPoints, yPoints, 3);
		
	}
	
	/**
	 * Paint one scoop
	 * @param g for Graphics object
	 * @param flavorIndex for the index of flavor
	 * @param x for x coordinate of the scoop
	 * @param y for y coordinate of the scoop
	 */
	private void paintScoop(Graphics g, int flavorIndex, int x, int y) {
		g.setColor(PAINT_COLORS[flavorIndex]);
		g.fillOval(x, y, SCOOP_DIAMETER, SCOOP_DIAMETER);
		
	}
	
	/**
	 * Paint scoops
	 * @param g for Graphics object
	 */
	private void paintScoops(Graphics g) {
		
		//Current y coordinate of the scoop
		int currentY = getHeight() - CONE_HEIGHT - SCOOP_DIAMETER + SCOOP_OVERLAP;
		
		while(!cone.getScoopFlavorStack().isEmpty()) {
			
			//Push top scoop of the original stack to the temporary stack
			tempStack.push(cone.getScoopFlavorStack().peek());
			
			cone.getScoopFlavorStack().pop();
		}
		
		while(!tempStack.isEmpty()) {
			
			paintScoop(g, tempStack.peek(), (getWidth()-SCOOP_DIAMETER)/2, currentY);
			
			cone.getScoopFlavorStack().push(tempStack.peek());
			
			tempStack.pop();
			
			//Update y coordinate of the next scoop
			currentY = currentY - SCOOP_DIAMETER + SCOOP_OVERLAP;
		}
	}
	
}
