/**
 * This class implements binomial heap. Algorithms are pretty much straight
 * from Introduction to algorithms by Cormen, Leiserson, Rivest and Stein.
 * 
 * @author Janne Haapsaari
 */

package main.fi.haaja.datastructures.binomialheap;


import java.util.Stack;

public class BinomialHeap {
	
	/** Reference to the root node */
	private BinomialNode root;
	
	/** Number of nodes */
	private int numNodes;
	
	
	
	/**
	 * Constructor that creates an empty binomial heap.
	 */
	public BinomialHeap() {
		
		this.root = null;
	}
	
	
	
	/**
	 * Constructor that creates heap with initial node.
	 * 
	 * @param node The initial node
	 * @param nodes Number of nodes in the initial binomial tree
	 */
	public BinomialHeap(BinomialNode node, int nodes) {
		
		this.root = node;
		this.numNodes = nodes;
	}
	
	
	
	/**
	 * Returns reference to the root node.
	 * 
	 * @return Reference to the root node
	 */
	public BinomialNode getRoot() {
		
		return this.root;
	}
	
	
	
	/**
	 * Returns a reference to the element with a smallest key (priority) in 
	 * the heap.
	 * 
	 * In book: BINOMIAL-HEAP-MINIMUM
	 * 
	 * @return 	Element with the smallest key in the heap,
	 * 			returns the root if all the elements have same priority,
	 * 			returns null in case of empty heap
	 */
	public BinomialNode minimum() {
		
		BinomialNode y = null;
		BinomialNode x = this.root;
		int min = Integer.MAX_VALUE;
		
		while (x != null) {
			if (x.getPriority() < min) {
				min = x.getPriority();
				y = x;
			}
			
			x = x.getSibling();
		}
		
		return y;
	}
	
	
	
	/**
	 * Links two binomial trees together. y will become the child of the
	 * z. Used as a subroutine by some of the remaining operations.
	 * 
	 * In book: BINOMIAL-LINK
	 * 
	 * @param y Binomial tree that will be the child of z
	 * @param z Binomial tree that will be the parent of y
	 */
	public void link(BinomialNode y, BinomialNode z) {
		
		y.setParent(z);
		y.setSibling(z.getChild());
		
		z.setChild(y);
		z.setDegree(z.getDegree()+1);
	}
	
	
	
	/**
	 * Union method has two phases. In first phase the method merges the root 
	 * lists of binomial heaps H1 and H2 into a heap "linked list" by calling 
	 * merge. Merge will sort the heap by degree into monotonically 
	 * increasing order.
	 * 
	 * In book: BINOMIAL-HEAP-UNION
	 * 
	 * @param H1 Heap to be united with H2
	 * @param H2 Heap to be united with H1
	 * @return new heap containing elements from both H1 and H2
	 */
	public BinomialHeap union(BinomialHeap heap1, BinomialHeap heap2) {
			
		BinomialHeap heap;
		
		//phase one
		heap = new BinomialHeap(merge(heap1, heap2), (heap1.numNodes+heap2.numNodes));
		if (heap.root == null) {
			return heap;
		}		
		
		//phase two
		BinomialNode previous = null;
		BinomialNode current = heap.root;
		BinomialNode next = current.getSibling();
		
		while (next != null) {
			
			if ((current.getDegree() != next.getDegree()) ||
				(next.getSibling() != null) &&
				(next.getSibling().getDegree() == current.getDegree())) {
				
				previous = current;
				current = next;
			}
			else {
				if (current.getPriority() <= next.getPriority()) {
					current.setSibling(next.getSibling());
					link(next, current);
				}
				else {
					if (previous == null) {
						heap.root = next;
					}
					else {
						previous.setSibling(next);
					}
					link(current, next);
					current = next;
				}
			}
			next = current.getSibling();
		}
		
		return heap;
	}
	
	
	
	/**
	 * Decreases the key value of the given node to the value key. Used
	 * with delete operation.
	 * 
	 * In book: BINOMIAL-HEAP-DECREASE-KEY
	 * 
	 * @param node The node to be decreased
	 * @param priority New priority value for node
	 * @exception IllegalArgumentExeception if new key is greater than current key.
	 */
	public void decreaseKey(BinomialNode node, int priority) {
		
		if (priority > node.getPriority()) {
			throw new IllegalArgumentException("decreaseKey() new " +
						"priority is greater than current priority.");
		}
		
		node.setPriority(priority);
		BinomialNode y = node;
		BinomialNode z = y.getParent();
		
		while (z != null && y.getPriority() < z.getPriority()) {
			
			/* Data and other satellite elements should be swapped here too.
			 * In this example heap we only swap priority */
			int tempPriority = y.getPriority();
			y.setPriority(z.getPriority());
			z.setPriority(tempPriority);
			
			y = z;
			z = y.getParent();
		}
	}
	
	
	
	/**
	 * Deletes specific node from the heap. If some other node in the heap has
	 * priority of Integer.MIN_VALUE, this function may remove wrong node from
	 * the heap.
	 * 
	 * @param node Node to be deleted
	 */
	public void delete(BinomialNode node) {
		
		if (this.isEmpty()) {
			return;
		}
		else {
			this.decreaseKey(node, Integer.MIN_VALUE);
			this.removeMin();
		}
	}
	
	
	
	/**
	 * Returns true if the heap is empty
	 * @return true if heap is empty, otherwise false
	 */
	public boolean isEmpty() {
		
		return this.numNodes == 0;
	}
	
	
	
	/**
	 * Returns the number of elements in the heap
	 * 
	 * @return the number of elements in heap
	 */
	public int size() {
		
		return this.numNodes;
	}
	/**
	 * Inserts a node into binomial heap.
	 * 
	 * @param node node to be added into heap
	 * @return reference to the added node
	 */
	public BinomialNode insert(BinomialNode node) {
		
		return this.insert(node.getPriority());
	}
	
	
	
	/**
	 * Implemented to ease testing. No need to create new node separately.
	 * 
	 * @param priority Priority for the new node
	 * @return reference to the added node
	 */
	public BinomialNode insert(int priority) {
		
		BinomialNode newNode = new BinomialNode(priority);
		BinomialHeap newHeap = new BinomialHeap(newNode, 1);
		
		newHeap = union(this, newHeap);
		this.root = newHeap.root;
		this.numNodes++;
		
		return newNode;
	}
	
	
	
	/**
	 * Returns root list that is sorted by monotonically increasing degree.
	 * Returns the head of the new list.
	 * 
	 * In book: BINOMIAL-HEAP-MERGE (exercise 19.2-1)
	 * 
	 * @param paramH1 First heap to be merged
	 * @param paramH2 Second heap to be merged
	 * @return Reference to the root of the list
	 */
	public BinomialNode merge(BinomialHeap paramH1, BinomialHeap paramH2) {
		
		BinomialNode heap1 = null;
		BinomialNode heap2 = null;
	
		//check if either of the parameters are null
		if ((paramH1 != null) && (paramH1.getRoot() != null)) {
			heap1 = paramH1.getRoot();
		}
		
		if ((paramH2 != null) && (paramH2.getRoot() != null)) {
			heap2 = paramH2.getRoot();
		}
		
		if (heap1 == null) {
			return heap2;
		}
		else if (heap2 == null) {
			return heap1;
		}
		
		//node to be returned
		BinomialNode head;
		
		if (heap1.getDegree() < heap2.getDegree()) {
			head = heap1;
			heap1 = heap1.getSibling();
		}
		else {
			head = heap2;
			heap2 = heap2.getSibling();
		}
		
		BinomialNode current = head;
		while (heap1 != null && heap2 != null) {
			
			if (heap1.getDegree() < heap2.getDegree()) {
				current.setSibling(heap1);
				current = heap1;
				heap1 = heap1.getSibling();
			}
			else {
				current.setSibling(heap2);
				current = heap2;
				heap2 = heap2.getSibling();
			}
		}

		//link the current node to the rest of the list
		if (heap1 == null) {
			current.setSibling(heap2);
		}
		else {
			current.setSibling(heap1);
		}
		
		return head;
	}

	
	
	/**
	 * Removes the node with smallest key in the heap.
	 * 
	 * In book: BINOMIAL-HEAP-EXTRACT-MIN
	 * 
	 * @return Node with the smallest key
	 */
	public BinomialNode removeMin() {
		
		if (this.isEmpty()) {
			return null;
		}
		
		BinomialNode previous = null;
		BinomialNode minPrevious = null;
		BinomialNode current = this.root;
		BinomialNode minCurrent = this.root;
		BinomialHeap heap = null;
		
		//find the smallest node from the root list
		while (current != null) {
		
			if (current.getPriority() < minCurrent.getPriority()) {
				minCurrent = current;
				minPrevious = previous;
			}
			previous = current;
			current = current.getSibling();
		}
		
		if (minPrevious == null) {
			this.root = this.root.getSibling();
		}
		else {
			minPrevious.setSibling(minCurrent.getSibling());
		}
		
		//new heap from childrens of the smallest node
		heap = new BinomialHeap(reverse(minCurrent.getChild()), 0);
		current = heap.root;
		while (current != null) {
			
			current.setParent(null);
			current = current.getSibling();
		}
		
		minCurrent.setSibling(null);
		minCurrent.setChild(null);
		minCurrent.setDegree(0);
		
		heap = union(this, heap);
		this.root = heap.root;
		this.numNodes--;
		
		return minCurrent;
	}
	
	
	
	/**
	 * Reverses the linked list of roots.
	 * 
	 * @param firstNode Reference to the first node in root list
	 * @return Reference to the new root
	 */
	public BinomialNode reverse(BinomialNode firstNode) {
		
		if (firstNode == null) {
			return null;
		}
		
		BinomialNode previous = null;
		BinomialNode current = firstNode;
		BinomialNode next = firstNode.getSibling();
		
		while (next != null) {
			current.setSibling(previous);
			previous = current;
			current = next;
			next = current.getSibling();
		}
		
		current.setSibling(previous);
		
		return current;
	}
	

		
	/**
	 * Depth first travelsal of the heap
	 */
	public void printHeap() {
		
		if (this.root == null) {
			return;
		}
		
		Stack stack = new Stack();
		stack.push(this.root);
		BinomialNode current;
		
		while (stack.empty() == false) {
			
			current = (BinomialNode)stack.pop();
			System.out.println(current);
			
			if (current.getSibling() != null) {
				stack.push(current.getSibling());
			}
			
			current = current.getChild();
			
			if (current != null) {
				stack.push(current);
			}
		}
		
	}
		
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		BinomialHeap testHeap = new BinomialHeap();
		
		testHeap.insert(1);
		testHeap.insert(10);
		testHeap.insert(100);
		testHeap.insert(12);
		testHeap.insert(18);
		testHeap.insert(25);
		testHeap.insert(6);
		testHeap.insert(8);
		testHeap.insert(-20);		
		
		System.out.println("Depth first travelsal of the heap: ");
		testHeap.printHeap();

	}

}
