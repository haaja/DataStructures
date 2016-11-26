/**
 *	LinkedList.java
 *
 *	@author Janne Haapsaari <haaja@iki.fi>
 *
 *	This class implements a simple doubly linked list that is used to
 *	access the last element in binary heap within O(1) time. Does not implement
 *	all the usual operations of a linked list. Uses HeapNode as an element.
 */

package main.fi.haaja.datastructures.binaryheap;

import java.util.NoSuchElementException;

public class LinkedList {

    //reference to the first node in linked list
    private HeapNode firstNode;

    //reference to the last node in linked list
    private HeapNode lastNode;

    //amount of nodes in linked list
    private int nodeCount;


    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {

        this.firstNode = null;
        this.lastNode = null;
        this.nodeCount = 0;

    }


    /**
     * Sets the first node of a linked list.
     *
     * @param node Node to be set as the first node
     */
    public void setFirstNode(HeapNode node) {

        this.firstNode = node;
    }


    /**
     * Rerturns a reference to the first node in list. Does not remove
     * it from the list!
     *
     * @return Reference to the first node in the list
     */
    public HeapNode getFirstNode() {

        return this.firstNode;
    }


    /**
     * Sets the last node of a list.
     *
     * @param node Node to be set as the last node in list
     */
    public void setLastNode(HeapNode node) {

        this.lastNode = node;
    }


    /**
     * Returns a reference to the last node in list. Does not remove it
     * from the list!
     *
     * @return A reference to the last node in list
     */
    public HeapNode getLastNode() {

        return this.lastNode;
    }


    /**
     * Inserts a node as the last node in list.
     *
     * @param node Node to be added as the last node of the list
     */
    public void insertLast(HeapNode node) {

        if (this.isEmpty()) {
            this.firstNode = node;
            this.lastNode = node;

            this.firstNode.setListNext(null);
            this.firstNode.setListPrevious(null);

            this.lastNode.setListNext(null);
            this.lastNode.setListPrevious(null);

            this.nodeCount++;
        }
        else {
            this.lastNode.setListNext(node);
            node.setListPrevious(this.lastNode);
            this.lastNode = node;
            this.nodeCount++;
        }
    }


    /**
     * Removes the last node from the list
     *
     * @return Removed node
     */
    public HeapNode removeLastNode() {

        HeapNode lastNode;

        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        else if (this.nodeCount == 1) {
            lastNode = this.lastNode;

            this.firstNode = this.lastNode = null;
            this.nodeCount--;
        }
        else {
            lastNode = this.lastNode;

            this.lastNode = this.lastNode.getListPrevious();
            this.lastNode.setListNext(null);
            this.nodeCount--;
        }

        return lastNode;
    }


    /**
     * Tests if the list is empty
     * @return
     */
    public boolean isEmpty() {

        return this.nodeCount == 0;
    }


    /**
     * Returns the number of elements in this list
     *
     * @return the number of elements in this list
     */
    public int size() {

        return this.nodeCount;
    }


    /**
     * Prints the elements in list (multiple lines)
     */
    public void printListNodesManyLines() {

        HeapNode temp = this.firstNode;
        int counter = 1;

        while (temp != null) {
            System.out.println(counter+". node, node priority: "+temp.getPriority());
            if (temp.getListNext() != null) {
                System.out.println("\tData of the next node: "+temp.getListNext().getPriority());
            }
            else {
                System.out.println("\tNext element is null!");
            }

            if (temp.getListPrevious() != null) {
                System.out.println("\tData of the previous node: "+temp.getListPrevious().getPriority());
            }
            else {
                System.out.println("\tPrevious element is null!");
            }

            temp = temp.getListNext();
            counter++;
        }
    }


    /**
     * Prints list content in one line
     */
    public void printListNodesOneLiner() {

        HeapNode temp = this.firstNode;

        System.out.print("List content: ");
        while (temp != null) {
            System.out.print(temp.getPriority()+" ");
            temp = temp.getListNext();
        }
        System.out.println("\n");
    }

}
