/**
 *  HeapNode.java
 *
 *  @author Janne Haapsaari <haaja@iki.fi>
 *  
 *  Implements a simple node used in Heap and LinkedList. This node does not
 *  hold any data but contains simply integer for priority. Smaller the priority,
 *  higher the priority.
 *  
 */

package main.fi.haaja.datastructures.binaryheap;

public class HeapNode {

	//priority of the node
    private int priority;
    
    //reference to the parent node in binary heap
    private HeapNode parent;
    
    //reference to the left child node in binary heap
    private HeapNode leftChild;
    
    //reference to the right child node in binary heap
    private HeapNode rightChild;
    
    //reference to the next node in linked list
    private HeapNode listNext;
    
    //reference to the previous node in linked list
    private HeapNode listPrevious;
    
    
    /**
     * Constructs HeapNode object.
     * 
     * @param data Integer data that the node will hold.
     */
    public HeapNode(int priority) {
    	
    	this.priority = priority;
    	this.parent = null;
    	this.leftChild = null;
    	this.rightChild = null;
    	this.listNext = null;
    	this.listPrevious = null;
    }

    
    /**
     *  Sets the parent node.
     *  
     *  @param parent Parent node
     */
    public void setParent(HeapNode parent) {

        this.parent = parent;
    }


    /**
     *  Returns a reference to the parent node in heap.
     *  
     *  @return A reference to the parent node
     */
    public HeapNode getParent() {
        
        return this.parent;
    }


    /**
     * Sets the right child node.
     * 
     * @param Right child node to be
     */
    public void setRight(HeapNode right) {

        this.rightChild = right;
    }

    
    /**
     *  Returns a reference to the right child node in heap.
     *  
     *  @return A reference to the right child node
     */
    public HeapNode getRight() {

        return this.rightChild;
    }

    
    /**
     *  Sets the left child node.
     *  
     *  @param A reference to the left child node in the heap
     */
    public void setLeft(HeapNode left) {

        this.leftChild = left;
    }


    /**
     *  Returns a reference to the left child node in the heap.
     *  
     *  @return A reference to the left child node
     */
    public HeapNode getLeft() {

        return this.leftChild;
    }


    /**
     *  Sets priority of the node.
     *  
     *  @param priority Priority for the node
     */
    public void setPriority(int priority) {
        
        this.priority = priority;
    }


    /**
     *  Returns the priority of the node.
     *  
     *  @return Priority of the node
     */
    public int getPriority() {

        return this.priority;
    }

    
    /**
     * Set reference to the next node in linked list.
     * 
     * @param next Next node in linked list to be
     */
    public void setListNext(HeapNode next) {
    	
    	this.listNext = next;
    }
    
    
    /**
     * Returns a reference to the next node in linked list.
     * 
     * @return A reference to the next node
     */
    public HeapNode getListNext() {
    	
    	return this.listNext;
    }
    
    
    /**
     * Sets a reference to the previous node in linked list
     * 
     * @param previous A reference to the previous node
     */
    public void setListPrevious(HeapNode previous) {
    	
    	this.listPrevious = previous;
    }
    
    
    /**
     * Returns a reference to the previous node in linked list.
     * 
     * @return A reference to the previous node
     */
    public HeapNode getListPrevious() {
    	
    	return this.listPrevious;
    }

    
    /**
     * 	Is the node leaf or not
     * 
     * 	@return true if the node is a leaf, otherwise false
     */
    public boolean isLeaf() {
    	
    	return (this.getLeft() == null && this.getRight() == null);
    }
    
    
    /**
     * Swaps priority of two nodes. This way we do not need to swap object 
     * references. If the nodes would contain actual data, the data should also
     * be swapped here. Since we are using the same nodes in LinkedList and Heap,
     * the data is also "swapped" within the list.
     * 
     * @param node Node containing data to be swapped
     */
    public void swap(HeapNode node) {
    	
    	int temp = this.priority;
    	this.priority = node.getPriority();
    	node.setPriority(temp);
    }
    
}
