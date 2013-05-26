/**
 *  Heap.java
 *
 *  @author Janne Haapsaari <haaja@iki.fi>
 *  
 *  
 *  Implements miminum binary heap using object references.
 *  
 *  NOTE:
 *  Only following operations are implemented:
 *  	- Building heap from binary tree in O(n) time.
 *  	- Inserting new node in O(lg n) time.
 *  	- Removing smallest element in O(lg n) time.
 *  
 *  
 *  The biggest problem of implementing binary heap without array is how to
 *  find a place for new node in O(1) time. Simple solution used here is to
 *  maintain a doubly linked list of the same nodes. This way we can find last 
 *  node and its parent node fast.
 */

package main.fi.haaja.datastructures.binaryheap;

import java.util.NoSuchElementException;


public class Heap {

	//reference to the root node of the heap
    private HeapNode rootNode;
    
    //reference to the linked list
    private LinkedList list;
    
    //number of node in the heap
    private int nodesCount;


    /**
     *	Constructor that creates an empty binary heap.
     */
    public Heap() {

        this.rootNode = null;
        this.list = new LinkedList();
        this.nodesCount = 0;
    }

    
    /**
     *	Inserts node into the heap. Calls heapifyUp to maintain heap property.
     *
     * 	@param node The node to be inserted.
     */
    public void insertNode(HeapNode node) {

    	//if empty heap
    	if (this.isEmpty()) {
    		this.rootNode = node;
    		this.list.insertLast(node);
    		this.nodesCount++;
    	}
    	else {
    		HeapNode lastNode = this.list.getLastNode();
    		
    		//if only root element in heap
    		if (lastNode.getParent() == null) {

    			lastNode.setLeft(node);
    			node.setParent(lastNode);
    		}
    		else {
    			lastNode = lastNode.getParent();
    			
        		//if no left child node
        		if (lastNode.getLeft() == null) {
        			lastNode.setLeft(node);
        			node.setParent(lastNode);
        		}
        		//if no right child node
        		else if (lastNode.getRight() == null) {
        			lastNode.setRight(node);
        			node.setParent(lastNode);
        		}
        		//both childs are used
        		else {
        			lastNode.getListNext().setLeft(node);
        			node.setParent(lastNode.getListNext());
        		}
    		}
    		
    		this.list.insertLast(node);
    		this.nodesCount++;
    		this.heapifyUp(this.list.getLastNode());
    	}
    }
    
    
    /**
     * Maintains heap property after insertion.
     * 
     * @param movingNode Node that is moved upwards.
     */
    public void heapifyUp(HeapNode movingNode) {
    	    	
    	while (movingNode != this.rootNode) {
    		
    		if (movingNode.getPriority() < movingNode.getParent().getPriority()) {
    			movingNode.swap(movingNode.getParent());
    		}
    		else {
    			break;
    		}
    		
    		movingNode = movingNode.getParent();
    	}
    }
    
    
    /**
     * Makes sure the heap property holds after removal of root (smallest) node.
     * 
     * @param movingNode Node that is moved downwards
     */
    public void heapifyDown(HeapNode movingNode) {
    	    	
    	while (movingNode.getLeft() != null) {
    		
        	HeapNode leftChild = movingNode.getLeft();
        	HeapNode rightChild = movingNode.getRight();
        	HeapNode smallerChild = leftChild;
    	
        	if (rightChild != null && 
        		rightChild.getPriority() < smallerChild.getPriority()) {
        		smallerChild = rightChild;
        	}

    		if (movingNode.getPriority() > smallerChild.getPriority()) {
    			smallerChild.swap(movingNode);
    		}
    		else {
    			break;
    		}
    		
    		movingNode = smallerChild;
    	}
    }
    
    
    /**
     * Removes and returns the smallest node (root node) from the heap.
     * 
     * @return Smallest node in the heap or null if the heap is empty.
     */
    public HeapNode removeMin() {
    	
    	//if empty heap
    	if (this.isEmpty()) {
    		throw new NoSuchElementException();
    		//return null;
    	}
    	//if only root node
    	else if (this.nodesCount == 1) {
    		HeapNode minNode = this.rootNode;
    		this.nodesCount--;
    		this.list.removeLastNode();
    		this.rootNode = null;
    		
    		return minNode;
    	}
    	
    	HeapNode minNode = new HeapNode(this.getRoot().getPriority());
    	HeapNode lastNode = this.list.getLastNode();
    	HeapNode lastNodesParent = lastNode.getParent();
    	
    	this.getRoot().swap(lastNode);
    	
    	if (lastNode == lastNodesParent.getLeft()) {
    		lastNodesParent.setLeft(null);
    	}
    	else {
    		lastNodesParent.setRight(null);
    	}
    	
    	
    	this.list.removeLastNode();
    	this.nodesCount--;
    	this.heapifyDown(this.rootNode);
    	
    	return minNode;	
    }
    
    
    /**
     * Builds heap using insertNode method.
     * Runs in O(n*lg n) time.
     * 
     * @param elems Integer array containing priorities for new elements.
     */
    public void buildHeapSlower(int[] elems) {
    	
    	for (int i=0; i<elems.length; i++) {
    		HeapNode node = new HeapNode(elems[i]);
    		this.insertNode(node);
    	}
    }
    
    
    /**
     * Faster way to build a binary heap. Establish heap property from an 
     * arbitrary arrangement of items in a binary tree. Runs in O(n) time.
     */
    public void buildHeap() {
    	
    	HeapNode movingNode = this.list.getLastNode().getParent();
    	    	
    	while(movingNode.getListPrevious() != null) {
    		heapifyDown(movingNode);
    		movingNode = movingNode.getListPrevious();
    	}
    	
    	//lets not forget the root node
    	heapifyDown(this.rootNode);
    }
    
    
    /**
     * Converts array of integers into binary tree. Does not hold the heap
     * property. This is method is used to demonstrate the ability to create
     * binary heap from binary tree in O(n) time.
     * 
     * @param elems Integer array containing priorities for nodes
     */
    public void convertIntArrayToBinaryTree(int[] elems) {
    	
    	for (int i = 0; i < elems.length; i++) {
    		
    		HeapNode node = new HeapNode(elems[i]);
        	
    		//if empty heap
        	if (this.isEmpty()) {
        		this.rootNode = node;
        	}
        	else {
        		HeapNode lastNode = this.list.getLastNode();
        		
        		//if only root element in heap
        		if (lastNode.getParent() == null) {
        			
        			if (lastNode.getLeft() == null) {
        				lastNode.setLeft(node);
        			}

        			node.setParent(lastNode);
        		}
        		else {
        			lastNode = lastNode.getParent();
            		//if no left child node
            		if (lastNode.getLeft() == null) {
            			lastNode.setLeft(node);
            			node.setParent(lastNode);
            		}
            		//if no right child node
            		else if (lastNode.getRight() == null) {
            			lastNode.setRight(node);
            			node.setParent(lastNode);
            		}
            		//both childs are used
            		else {
            			lastNode.getListNext().setLeft(node);
            			node.setParent(lastNode.getListNext());
            		}
        		}
        	}
        	
        	this.list.insertLast(node);
    		this.nodesCount++;
    	}
    }
        
        
    /**
     * Returns a reference to the root node of the heap.
     * 
     * @return Reference to the root node.
     */
    public HeapNode getRoot() {

        return this.rootNode;
    }

    
    /**
     * Returns true if heap size is zero and false otherwise.
     * 
     * @return true if heap size is zero, otherwise false
     */
    public boolean isEmpty() {
    	
    	return (this.size() == 0);
    }
    
    
    /**
     * Returns the size of the heap.
     * 
     * @return The amount of nodes in the heap
     */
    public int size() {
    	
    	return this.nodesCount;
    }

}
