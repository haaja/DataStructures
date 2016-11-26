/**
 * LinkedListTest.java
 *
 * @author Janne Haapsaari <haaja@iki.fi>
 *
 * Unit test for LinkedList class.
 */

package fi.haaja.datastructures.binaryheaptests;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;
import main.fi.haaja.datastructures.binaryheap.*;


public class LinkedListTest {


    @Test
    public void constructorTest() {

        LinkedList testList = new LinkedList();

        assertEquals(0, testList.size());
        assertEquals(true, testList.isEmpty());
        assertEquals(null, testList.getFirstNode());
        assertEquals(null, testList.getLastNode());

    }


    @Test
    public void setFirstNodeTest() {

        LinkedList testList = new LinkedList();

        for(int i=0; i<1000; i++) {

            HeapNode testNode = new HeapNode((int)(Math.random()*1000));
            testList.setFirstNode(testNode);
            assertEquals(testNode, testList.getFirstNode());

        }

    }


    @Test
    public void getFirstNodeTest() {

        LinkedList testList = new LinkedList();

        for(int i=0; i<1000; i++) {

            HeapNode testNode = new HeapNode((int)(Math.random()*1000));
            testList.setFirstNode(testNode);
            assertEquals(testNode, testList.getFirstNode());

        }

    }


    @Test
    public void setLastNodeTest() {

        LinkedList testList = new LinkedList();

        for(int i=0; i<1000; i++) {

            HeapNode testNode = new HeapNode((int)(Math.random()*1000));
            testList.setLastNode(testNode);
            assertEquals(testNode, testList.getLastNode());

        }

    }


    @Test
    public void getLastNodeTest() {

        LinkedList testList = new LinkedList();

        for(int i=0; i<1000; i++) {

            HeapNode testNode = new HeapNode((int)(Math.random()*1000));
            testList.setLastNode(testNode);
            assertEquals(testNode, testList.getLastNode());

        }

    }


    @Test
    public void insertLastTest() {

        int testSize = 1000;
        LinkedList testList = new LinkedList();
        HeapNode[] testNodes = new HeapNode[testSize];

        for (int i=0; i<testNodes.length; i++) {
            int rNumber = (int)(Math.random()*10000);
            HeapNode testNode = new HeapNode(rNumber);
            testNodes[i] = testNode;

            testList.insertLast(testNode);
            assertEquals((i+1), testList.size());
        }

        HeapNode node = testList.getFirstNode();

        for (int i=0; i<testNodes.length; i++) {
            assertEquals(testNodes[i], node);
            node = node.getListNext();
        }

        node = testList.getLastNode();
        for(int i=testNodes.length-1; i>=0; i--) {
            assertEquals(testNodes[i], node);
            node = node.getListPrevious();
        }
    }


    @Test
    public void removeLastTest() {

        int testSize = 1000;
        LinkedList testList = new LinkedList();
        HeapNode[] testNodes = new HeapNode[testSize];

        for (int i=0; i<testNodes.length; i++) {
            int rNumber = (int)(Math.random()*10000);
            HeapNode testNode = new HeapNode(rNumber);
            testNodes[i] = testNode;

            testList.insertLast(testNode);
            assertEquals((i+1), testList.size());
        }

        for (int i=testNodes.length-1; i>=0; i--) {

            HeapNode temp = new HeapNode(999);

            try {
                temp = testList.removeLastNode();
            }catch (NoSuchElementException e) {
                e.printStackTrace();
            }catch (Exception e) {
                e.printStackTrace();
            }catch (Error e) {
                e.printStackTrace();
            }

            assertEquals(testNodes[i], temp);
        }
    }


    @Test
    public void isEmptyTest() {

        LinkedList testList = new LinkedList();

        assertEquals(true, testList.isEmpty());

        testList.insertLast(new HeapNode((int)(Math.random()*1000)));

        assertEquals(false, testList.isEmpty());

        try {
            testList.removeLastNode();
        }catch (NoSuchElementException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }catch (Error e) {
            e.printStackTrace();
        }

        assertEquals(true, testList.isEmpty());

    }
}
