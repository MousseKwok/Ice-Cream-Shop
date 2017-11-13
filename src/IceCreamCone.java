import javax.swing.*;

/**
 * Ice Cream Model class
 * @author Xijie Guo
 *
 */
@SuppressWarnings("serial")
public class IceCreamCone {

	//Flavors of the ice cream
	public static final String[] FLAVORS = {"Valinna", "strawberry", "green tea", "burnt caramel"};
	
	//Maximum number of scoops
	public static final int RANDOM_MAX_SCOOPS = 4;
	
	//Original ice cream stack
	private StackLL<Integer> scoopFlavorStack;

	public IceCreamCone() {
		scoopFlavorStack = new StackLL<Integer>();
	}
	
	/**
	 * Get the original ice cream stack
	 * @return the original ice cream stack
	 */
	public Stack<Integer> getScoopFlavorStack() {
		return scoopFlavorStack;
	}
	
	/**
	 * Find the flavor index 
	 * @param flavor for the current flavor we want
	 * @return the index of the flavor in the flavor array
	 */
	public int findFlavorIdx(String flavor) {
		for(int i = 0; i < FLAVORS.length; i++) {
			if(FLAVORS[i] == flavor) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Add a scoop according to the flavor
	 * @param flavor for current flavor
	 */
	public void addScoop(String flavor) {
		scoopFlavorStack.push(findFlavorIdx(flavor));
		
	}
	
	/**
	 * Add a scoop of random flavor
	 */
	public void addScoop() {
		int randomFlavor = (int)(Math.random()*RANDOM_MAX_SCOOPS);
		scoopFlavorStack.push(randomFlavor);
	}
	
	/**
	 * Pop the top scoop out of the stack
	 */
	public void popTopScoop() {
		if(!scoopFlavorStack.isEmpty()) {
			scoopFlavorStack.pop();
		}
	}
	
	/**
	 * Create ice cream cone with random scoops
	 * @return the generated iceCreamCone
	 */
	public static IceCreamCone createRandom() {
		IceCreamCone iceCreamCone = new IceCreamCone();
		//Generate random number of scoops
		int randomNumOfScoop = (int)(1+Math.random()*(4-1));
		//Add random number of scoops to an ice cream cone
		for(int i = 0; i < randomNumOfScoop; i++) {
			iceCreamCone.addScoop();
		}
		return iceCreamCone;
	}
	
	/**
	 * Use to remove the whole ice cream cone in the ice cream maker area
	 */
	public void popScoops() {
		//continue popping the scoop in the stack until there is no scoop to remove 
		//the whole ice cream cone
		while(!scoopFlavorStack.isEmpty()) {
			scoopFlavorStack.pop();
		}
	}
}

