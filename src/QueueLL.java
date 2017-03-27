/**
 * Queue class. This class can 
 * @author Xijie Guo
 *
 * @param <T> the general type
 */
public class QueueLL<T> implements Queue<T>{
	private LinkedList<T> list;
	
	/**
	 * Constructor of StackLL
	 */
	public QueueLL() {
		list = new LinkedList<T>();
	}
	
	/**
	 * Tests if the queue is empty
	 * @return true if the queue is empty
	 */
	public boolean empty() {
		if(list.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/** 
	 * Gets the element at the head of the queue without removing it.
	 * @return the peeked data
	 */
	public T peek() {
		return list.getLast();
	}
	
	/**
	 * Removes the item at the head of the queue
	 * @return the dequeued data
	 */
	public T dequeue() {
		T lastData = list.getLast();
		list.deleteLast();
		return lastData;
	}
	
	/**
	 * Enqueues an element at the tail of the queue
	 */
	public void enqueue(T data) {
		list.insertFirst(data);
	}
	
	/** 
	 * Returns a String representation of the queue
	 * @return the String representation 
	 */
	public String toString() {
		return list.toString();
	}
	
}
