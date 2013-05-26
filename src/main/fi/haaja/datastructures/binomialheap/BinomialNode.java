/**
 * This class implements simple node used in BinomialHeap.java. This node does
 * not contain data value! Data value could be easily added with accessors but
 * it wasn't required in the assignment.
 * 
 * Each node has 
 *  - a priority value which determines the order for the node. Smaller the 
 *    priority value, higher the priority.
 *  - degree, which is number of children the node has
 *  - references to the parent, child and sibling nodes
 * 
 * 
 * @author Janne Haapsaari
 */

package main.fi.haaja.datastructures.binomialheap;

public class BinomialNode {

	/** Data of the node (we are not using it) */
	//private int data;

	/** Priority of the node */
	private int priority;

	/** Number of children */
	private int degree;
		
	/** Object reference to the parent node */
	private BinomialNode parentNode;
	
	/** Object reference to the leftmost child node */
	private BinomialNode leftChildNode;
	
	/** Object reference to the sibling node */
	private BinomialNode siblingNode;
	
	
	
	/**
	 * Constructor
	 * @param data data of the node
	 * @param priority Priority of the node
	 */
	public BinomialNode(int priority) {
		
		this.priority = priority;
		this.parentNode = null;
		this.leftChildNode = null;
		this.siblingNode = null;
		this.degree = 0;
	}
	
	
	
	/**
	 * Sets the parent node
	 * 
	 * @param node Node to become new parent node
	 */
	public void setParent(BinomialNode node) {
		
		this.parentNode = node;
	}
	
	
	
	/**
	 * Returns a reference to the parent node
	 * 
	 * @return Reference to the parent node
	 */
	public BinomialNode getParent() {
		
		return this.parentNode;
	}
	
	
	
	/**
	 * Sets the child node.
	 * 
	 * @param node Node to become the new child node.
	 */
	public void setChild(BinomialNode node) {
		
		this.leftChildNode = node;
	}
	
	
	
	/**
	 * Returns a reference to the child node
	 * 
	 * @return Reference to the child node
	 */
	public BinomialNode getChild() {
		
		return this.leftChildNode;
	}
	
	
	
	/**
	 * Sets the sibling node
	 * 
	 * @param node Node to become the new sibling node
	 */
	public void setSibling(BinomialNode node) {
		
		this.siblingNode = node;
	}
	
	
	
	/**
	 * Returns a reference to the sibling node
	 * 
	 * @return Reference to the sibling node
	 */
	public BinomialNode getSibling() {
		
		return this.siblingNode;
	}
	
	
	
	/**
	 * Sets the priority of the node
	 * 
	 * @param priority Priority to be
	 */
	public void setPriority(int priority) {
		
		this.priority = priority;
	}
	
	
	
	/**
	 * Returns the priority of the node
	 * 
	 * @return The priority of the node
	 */
	public int getPriority() {
		
		return this.priority;
	}
	
	
	
	/**
	 * Sets the degree of the node
	 * 
	 * @param degree The degree of the node
	 */
	public void setDegree(int degree) {
		
		this.degree = degree;
	}
	
	
	
	/**
	 * Returns the degree of the node
	 * 
	 * @return Degree of the node
	 */
	public int getDegree() {
		
		return this.degree;
	}
	
	
	
	/**
	 * Converts the nodes data and priority to string
	 */
	public String toString() {
		if (false) {
			return "Priority: "+this.priority;
		
		} else {
	        StringBuffer buffer = new StringBuffer();
	        if (this.getParent() != null) {
	            buffer.append("Parent priority: "+Double.toString(this.getParent().getPriority()) + "\t");
	        } else {
	            buffer.append("Parent priority: null\t");
	        }
	        buffer.append("Node priority: "+Double.toString(this.getPriority()) + "\t");
	        buffer.append("Node degree: "+Integer.toString(this.getDegree()) + "\t");
	        if (this.getSibling() != null) {
	            buffer.append("Sibling priority: "+Double.toString(this.getSibling().getPriority()) + "\t");
	        } else {
	            buffer.append("Sibling priority: null\t");
	        }
	        if (this.getChild() != null) {
	            buffer.append("Leftmost child priority: "+Double.toString(this.getChild().getPriority()) + "\t");
	        } else {
	            buffer.append("Leftmost child priority: null\t");
	        }
	        return buffer.toString();
	    }
	}

}
