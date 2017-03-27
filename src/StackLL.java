/**
 * Stack class. This class can ask if a stack is empty, implement push, pop, peek, toString method
 */
public class StackLL<T> implements Stack<T> {
	private LinkedList<T> stack;
	
	/**
	 * Constructor of StackLL
	 */
	public StackLL() {
		stack = new LinkedList<T>();
	}
	
	/**
	 * Pushes an element onto the top of the stack.
	 */
	public void push( T data ) {
		stack.insertFirst(data);
	}
 
	/**
	 * Removes the top of the stack and returns it.
	 * @return the popped data
	 */
	public T pop() {
		T lastData = stack.getFirst();
		stack.deleteFirst();
		return lastData;
	}
 
	/** 
	 * Gets the element at the top of the stack without removing it.
	 * @return the peeked data
	 */
	public T peek() {
		return stack.getFirst();
	}
 
	/** 
	 * Tests if the stack is empty.
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		if(stack.isEmpty()) {
			return true;
		}
		
		return false;
	}
 
	/** 
	 * Returns a String representation of the stack.
	 * @return stack as String
	 */
	public String toString() {
		return stack.toString();
	}

	/**
	 * Get the size of the stack
	 * @return the size 
	 */
	public int size() {
		return stack.size();
	}
}

