/**
 * HeapNodeTest.java
 * 
 * @author Janne Haapsaari <haaja@iki.fi>
 * 
 * Unit tests for HeapNode class.
 */

package test.fi.haaja.datastructures.binaryheaptests;

import static org.junit.Assert.*;
import org.junit.Test;
import main.fi.haaja.datastructures.binaryheap.*;


public class HeapNodeTest {

	
	@Test
	public void constructorTest() {
		
		HeapNode testNode = new HeapNode(99);
		
		assertEquals(99, testNode.getPriority());
		assertEquals(null, testNode.getParent());
		assertEquals(null, testNode.getLeft());
		assertEquals(null, testNode.getRight());
		assertEquals(null, testNode.getListNext());
		assertEquals(null, testNode.getListPrevious());
	}
	
	
	@Test
	public void setParentTest() {
		
		HeapNode rootNode = new HeapNode(1);
		HeapNode secondNode = new HeapNode(2);
		
		secondNode.setParent(rootNode);
		assertEquals(rootNode, secondNode.getParent());
	}
	
	
	@Test
	public void getParentTest() {
		
		HeapNode rootNode = new HeapNode(1);
		HeapNode secondNode = new HeapNode(2);
		
		secondNode.setParent(rootNode);
		assertEquals(rootNode, secondNode.getParent());
	}
	
	
	@Test
	public void setRightTest() {
		
		HeapNode firstNode = new HeapNode(1);
		HeapNode secondNode = new HeapNode(2);
		
		firstNode.setRight(secondNode);
		secondNode.setRight(firstNode);
		assertEquals(secondNode, firstNode.getRight());
		assertEquals(firstNode, secondNode.getRight());
	}
	
	
	@Test
	public void getRightTest() {
	
		HeapNode firstNode = new HeapNode(1);
		HeapNode secondNode = new HeapNode(2);
		
		firstNode.setRight(secondNode);
		secondNode.setRight(firstNode);
		assertEquals(secondNode, firstNode.getRight());
		assertEquals(firstNode, secondNode.getRight());
	}
	
	
	@Test
	public void setPriorityTest() {
	
		HeapNode testNode = new HeapNode(1);
		
		for(int i=0; i<1000; i++) {
			int number = (int)(Math.random()*10000);
			testNode.setPriority(number);
			assertEquals(number, testNode.getPriority());
		}
	}
	
	
	@Test
	public void swapTest() {
		
		for(int i=0; i<1000; i++) {
			
			int number1 = (int)(Math.random()*10000);
			int number2 = (int)(Math.random()*10000);
			
			HeapNode testNode1 = new HeapNode(number1);
			HeapNode testNode2 = new HeapNode(number2);
			
			testNode1.swap(testNode2);
			
			assertEquals(number2, testNode1.getPriority());
			assertEquals(number1, testNode2.getPriority());
		}
	}
	
	
	@Test
	public void isLeafTest() {
		
		HeapNode testNode1 = new HeapNode(1);
		HeapNode testNode2 = new HeapNode(1);
		HeapNode testNode3 = new HeapNode(1);
		HeapNode testNode4 = new HeapNode(1);
		
		testNode1.setLeft(testNode2);
		testNode2.setRight(testNode3);
		testNode2.setLeft(testNode4);
		
		assertFalse(testNode1.isLeaf());
		assertFalse(testNode2.isLeaf());
		assertTrue(testNode3.isLeaf());
		assertTrue(testNode4.isLeaf());
	}
}
