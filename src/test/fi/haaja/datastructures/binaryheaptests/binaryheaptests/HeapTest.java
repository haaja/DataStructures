/**
 * HeapTest.java
 * 
 * @author Janne Haapsaari <haaja@iki.fi>
 * 
 * Unit tests for Heap.java class.
 */

package test.fi.haaja.datastructures.binaryheaptests;

import static org.junit.Assert.*;
import org.junit.Test;
import main.fi.haaja.datastructures.binaryheap.*;
import java.util.*;

public class HeapTest {
	
	
	@Test
	public void heapConstructorTest() {
		
		Heap testHeap = new Heap();
		
		assertEquals(0, testHeap.size());
		assertEquals(true, testHeap.isEmpty());
		assertEquals(null, testHeap.getRoot());

	}
	
	
	@Test
	public void insertNodeTest1() {
		
		Heap testHeap = new Heap();
		assertEquals(true, testHeap.isEmpty());
		
		HeapNode testNode = new HeapNode(1);
		testHeap.insertNode(testNode);
		assertEquals(false, testHeap.isEmpty());
		assertEquals(testNode, testHeap.getRoot());
		assertEquals(1, testHeap.size());
		assertEquals(null, testHeap.getRoot().getLeft());
		assertEquals(null, testHeap.getRoot().getRight());
	}
	
	
	@Test
	public void insertNodeTest2() {
		
		Heap testHeap = new Heap();
		assertEquals(true, testHeap.isEmpty());
		
		HeapNode testNode1 = new HeapNode((int)(Math.random()*1000));
		HeapNode testNode2 = new HeapNode((int)(Math.random()*1000));
		testHeap.insertNode(testNode1);
		testHeap.insertNode(testNode2);
		assertEquals(false, testHeap.isEmpty());
		assertEquals(2, testHeap.size());
		assertEquals(testNode1, testHeap.getRoot());
		assertEquals(testNode2, testHeap.getRoot().getLeft());
		assertEquals(null, testHeap.getRoot().getRight());
	}
	
	
	@Test
	public void insertNodeTest3() {
		
		Heap testHeap = new Heap();
		assertEquals(true, testHeap.isEmpty());
		
		HeapNode testNode1 = new HeapNode((int)(Math.random()*1000));
		HeapNode testNode2 = new HeapNode((int)(Math.random()*1000));
		HeapNode testNode3 = new HeapNode((int)(Math.random()*1000));
		
		testHeap.insertNode(testNode1);
		testHeap.insertNode(testNode2);
		testHeap.insertNode(testNode3);
		assertEquals(false, testHeap.isEmpty());
		assertEquals(3, testHeap.size());
		assertEquals(testNode1, testHeap.getRoot());
		assertEquals(testNode2, testHeap.getRoot().getLeft());
		assertEquals(testNode3, testHeap.getRoot().getRight());
	}
	
	
	@Test
	public void insertNodeTest4() {
		
		int testSize = 1000;
		Heap testHeap = new Heap();
		int[] testNodesData = new int[1000];
		
		for (int i=0; i<testNodesData.length; i++) {
			int rNumber = (int)(Math.random()*testSize);
			testNodesData[i] = rNumber;
			testHeap.insertNode(new HeapNode(rNumber));
		}
		
		assertEquals(testSize, testHeap.size());
		
	}
	
	
	@Test
	public void removeMinTest() {
		
		int testSize = 1000;
		Heap testHeap = new Heap();
		int[] testNodesData = new int[testSize];
		
		for (int i=0; i<testNodesData.length; i++) {
			int rNumber = (int)(Math.random()*testSize);
			//int rNumber = i;
			testNodesData[i] = rNumber;
			testHeap.insertNode(new HeapNode(rNumber));
		}
		
		assertEquals(testSize, testHeap.size());
		
		Arrays.sort(testNodesData);
		
		for (int i=0; i<testNodesData.length; i++) {
			HeapNode temp = testHeap.removeMin();
			assertEquals(testNodesData[i], temp.getPriority());
		}
		
	}
	
	
	@Test
	public void sizeTest() {
		
		Heap testHeap = new Heap();
		assertEquals(0, testHeap.size());

		HeapNode testNode1 = new HeapNode(1);
		testHeap.insertNode(testNode1);
		assertEquals(1, testHeap.size());
		
		testHeap.removeMin();
		assertEquals(0, testHeap.size());

	}
	
	
	@Test
	public void isEmptyTest() {
		
		Heap testHeap = new Heap();
		assertEquals(true, testHeap.isEmpty());

		HeapNode testNode1 = new HeapNode(1);
		testHeap.insertNode(testNode1);
		assertEquals(false, testHeap.isEmpty());
		
		testHeap.removeMin();
		assertEquals(true, testHeap.isEmpty());

	}
	
	
	@Test
	public void getRootTest() {
		
		Heap testHeap = new Heap();
		HeapNode testNode1 = new HeapNode(1);
		
		testHeap.insertNode(testNode1);
		assertEquals(testNode1, testHeap.getRoot());

	}

}
