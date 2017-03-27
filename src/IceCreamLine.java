import javax.swing.*;

/**
 * IceCreamLine class is responsible for checking if there is an order, adding order, and removing order. 
 * IceCreamLine class extends Box
 * @author Xijie Guo
 *
 */
@SuppressWarnings("serial")
public class IceCreamLine extends Box {
	//orderLine queue
	private QueueLL<IceCreamCone> orderLine;
	
	//orderLineView queue
	private QueueLL<IceCreamConeView> orderLineView;
	
	public IceCreamLine() {
		super(BoxLayout.Y_AXIS);
		orderLine = new QueueLL<IceCreamCone>();
		orderLineView = new QueueLL<IceCreamConeView>();
	}
	
	/**
	 * Check if there is an order
	 * @return true if the orderLine queue is not empty
	 */
	public boolean hasOrder() {
		if(orderLine.empty()) {
			return false;
		}
		return true;
	}
	
	/** 
	 * Add a random order in the orderLine queue
	 */
	public void addRandomOrder() {
		IceCreamCone cone = IceCreamCone.createRandom();
		//Enqueue the ice cream cone to the OrderLine queue
		orderLine.enqueue(cone);

		IceCreamConeView coneView = new IceCreamConeView(cone);
		//Enqueue the cone view
		orderLineView.enqueue(coneView);
		
		//Add the ice cream cone view to the frame
		add(coneView);
	}
	
	/**
	 * Remove the random order
	 */
	public void removeRandomOrder() {
		if(hasOrder()) {
			orderLine.dequeue();
			//Remove the cone view from the frame
			remove(orderLineView.dequeue());
		}
    }  
	
	/**
	 * Get the first order in the queue 
	 * @return the order
	 */
	public IceCreamCone getOrder() {
		if(hasOrder()) {
			return orderLine.peek();
		}
		return null;
	}
}
