/**
 * Unit tests for BinomialNode.java
 * 
 * @author Janne Haapsaari
 */

package test.fi.haaja.datastructures.binomialheaptests;

import main.fi.haaja.datastructures.binomialheap.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BinomialNodeTest {


	@Test
	public void constructorTest() {
		
		BinomialNode testNode = new BinomialNode(99);
		
		assertEquals(99, testNode.getPriority());
		assertEquals(null, testNode.getParent());
		assertEquals(null, testNode.getSibling());
		assertEquals(null, testNode.getChild());

	}
	
	
	@Test
	public void setParentTest() {
		
		BinomialNode rootNode = new BinomialNode(1);
		BinomialNode secondNode = new BinomialNode(2);
		
		secondNode.setParent(rootNode);
		assertEquals(rootNode, secondNode.getParent());
	}
	
	
	@Test
	public void getParentTest() {
		
		BinomialNode rootNode = new BinomialNode(1);
		BinomialNode secondNode = new BinomialNode(2);
		
		secondNode.setParent(rootNode);
		assertEquals(rootNode, secondNode.getParent());
	}
	
	
	@Test
	public void setChildTest() {
		
		BinomialNode firstNode = new BinomialNode(1);
		BinomialNode secondNode = new BinomialNode(2);
		
		firstNode.setChild(secondNode);
		secondNode.setParent(firstNode);
		assertEquals(secondNode, firstNode.getChild());
		assertEquals(firstNode, secondNode.getParent());
		assertEquals(null, secondNode.getChild());
	}
	
	
	@Test
	public void getChildTest() {
	
		BinomialNode firstNode = new BinomialNode(1);
		BinomialNode secondNode = new BinomialNode(2);
		
		firstNode.setChild(secondNode);
		assertEquals(secondNode, firstNode.getChild());
		assertEquals(null, secondNode.getChild());
	}
	
	
	@Test
	public void setGetPriorityTest() {
	
		BinomialNode testNode = new BinomialNode(1);
		
		for(int i=0; i<1000; i++) {
			int number = (int)(Math.random()*10000);
			testNode.setPriority(number);
			assertEquals(number, testNode.getPriority());
		}
	}

	
	@Test
	public void setGetDegreeTest() {
	
		BinomialNode testNode = new BinomialNode(1);
		
		for(int i=0; i<1000; i++) {
			int number = (int)(Math.random()*10000);
			testNode.setDegree(number);
			assertEquals(number, testNode.getDegree());
		}
	}
	
	
	@Test
	public void getGetSiblingTest() {
	
		BinomialNode firstNode = new BinomialNode(1);
		BinomialNode secondNode = new BinomialNode(2);
		
		firstNode.setSibling(secondNode);
		assertEquals(secondNode, firstNode.getSibling());
		assertEquals(null, secondNode.getSibling());
	}
}
