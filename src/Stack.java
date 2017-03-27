/**
 * Stack interface. You can push, pop, peek, ask if it is empty, make it a String representation of the stack
 * @author Xijie Guo
 *
 * @param <T> general type
 */
interface Stack<T> {
	
	/**
	 * Pushes an element onto the top of the stack.
	 */
	void push(T data);
	
	/**
	 * Removes the top of the stack and returns it.
	 * @return the popped data
	 */
	T pop();
	
	/** 
	 * Gets the element at the top of the stack without removing it.
	 * @return the peeked data
	 */
	T peek();
	
	/** 
	 * Tests if the stack is empty.
	 * @return true if the stack is empty
	 */
	boolean isEmpty();
	
	/** 
	 * Returns a String representation of the stack.
	 * @return stack as String
	 */
	String toString();
	
	/**
	 * Gets the size of the stack
	 * @return the size of the stack
	 */
	int size();
}