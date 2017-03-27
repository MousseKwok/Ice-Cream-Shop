/**
 * A Queue interface. You can ask if it is empty, add an element, remove an element, peek at the front 
 * item, and make it a String representation of the queue
 * @author Xijie Guo
 *
 * @param <T> general type
 */
interface Queue<T> {
	
	/**
	 * Tests if the queue is empty
	 * @return true if the queue is empty
	 */
	boolean empty();
	
	/** 
	 * Gets the element at the head of the stack without removing it.
	 * @return the peeked data
	 */
	T peek();
	
	/**
	 * Removes the item at the head
	 * @return the dequeued data
	 */
	T dequeue();
	
    /**
     * Adds the given item to the tail of the queue
     * @param data the element data
     */
	void enqueue(T data);
	
	/**
	 * Make the string representation of the queue
	 * @return the string representation
	 */
	String toString();
	
}