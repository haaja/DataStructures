/**
 * BinomialHeapTest.java
 *
 * @author Janne Haapsaari
 */

package test.fi.haaja.datastructures.binomialheaptests;

import main.fi.haaja.datastructures.binomialheap.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BinomialHeapTest {


    @Test
    public void heapConstructorTest() {

        BinomialHeap testHeap = new BinomialHeap();

        assertEquals(true, testHeap.isEmpty());
        assertEquals(null, testHeap.getRoot());

    }


    @Test
    public void setGetRootTest() {

        BinomialHeap testHeap = new BinomialHeap();
        assertEquals(true, testHeap.isEmpty());
        assertEquals(null, testHeap.getRoot());

        BinomialNode testNode = new BinomialNode(1);
        testHeap.insert(testNode);
        assertEquals(1, testHeap.getRoot().getPriority());

    }


    @Test
    public void insertNodeTest1() {

        BinomialHeap testHeap = new BinomialHeap();
        assertEquals(true, testHeap.isEmpty());

        BinomialNode testNode = new BinomialNode(1);
        testHeap.insert(testNode);
        assertEquals(false, testHeap.isEmpty());
        assertEquals(1, testHeap.size());
        assertEquals(1, testHeap.getRoot().getPriority());
        assertEquals(null, testHeap.getRoot().getChild());
        assertEquals(null, testHeap.getRoot().getSibling());
        assertEquals(null, testHeap.getRoot().getParent());
    }

    @Test
    public void insertNodeTest2() {

        BinomialHeap testHeap = new BinomialHeap();
        assertEquals(true, testHeap.isEmpty());

        BinomialNode testNode1 = new BinomialNode(1);
        BinomialNode testNode2 = new BinomialNode(2);
        testHeap.insert(testNode1);
        testHeap.insert(testNode2);
        assertEquals(false, testHeap.isEmpty());
        assertEquals(2, testHeap.size());
        assertNotNull(testHeap.getRoot().getChild());
        assertEquals(1, testHeap.getRoot().getPriority());
        assertEquals(2, testHeap.getRoot().getChild().getPriority());
        assertEquals(null, testHeap.getRoot().getSibling());
    }


    @Test
    public void insertNodeTest3() {

        BinomialHeap testHeap = new BinomialHeap();
        assertEquals(true, testHeap.isEmpty());

        BinomialNode testNode1 = new BinomialNode(3);
        BinomialNode testNode2 = new BinomialNode(2);
        BinomialNode testNode3 = new BinomialNode(1);

        testHeap.insert(testNode1);
        testHeap.insert(testNode2);
        testHeap.insert(testNode3);
        assertEquals(false, testHeap.isEmpty());
        assertEquals(3, testHeap.size());
        assertEquals(1, testHeap.getRoot().getPriority());
        assertEquals(2, testHeap.getRoot().getSibling().getPriority());
        assertEquals(3, testHeap.getRoot().getSibling().getChild().getPriority());

    }


    @Test
    public void insertNodeTest4() {

        BinomialHeap testHeap = new BinomialHeap();
        assertEquals(true, testHeap.isEmpty());

        BinomialNode testNode1 = new BinomialNode(2);
        BinomialNode testNode2 = new BinomialNode(3);
        BinomialNode testNode3 = new BinomialNode(1);

        testHeap.insert(testNode1);
        testHeap.insert(testNode2);
        testHeap.insert(testNode3);
        assertEquals(false, testHeap.isEmpty());
        assertEquals(3, testHeap.size());
        assertEquals(1, testHeap.getRoot().getPriority());
        assertEquals(2, testHeap.getRoot().getSibling().getPriority());
        assertEquals(3, testHeap.getRoot().getSibling().getChild().getPriority());

    }


    @Test
    public void insertNodeTest5() {

        BinomialHeap testHeap = new BinomialHeap();
        assertEquals(true, testHeap.isEmpty());

        BinomialNode testNode1 = new BinomialNode(1);
        BinomialNode testNode2 = new BinomialNode(2);
        BinomialNode testNode3 = new BinomialNode(3);
        BinomialNode testNode4 = new BinomialNode(4);
        BinomialNode testNode5 = new BinomialNode(5);
        BinomialNode testNode6 = new BinomialNode(6);

        testHeap.insert(testNode1);
        testHeap.insert(testNode2);
        testHeap.insert(testNode3);
        testHeap.insert(testNode4);
        testHeap.insert(testNode5);
        testHeap.insert(testNode6);

        assertEquals(false, testHeap.isEmpty());
        assertEquals(6, testHeap.size());
        assertEquals(5, testHeap.getRoot().getPriority());
        assertEquals(6, testHeap.getRoot().getChild().getPriority());
        assertEquals(1, testHeap.getRoot().getSibling().getPriority());
        assertEquals(3, testHeap.getRoot().getSibling().getChild().getPriority());
        assertEquals(4, testHeap.getRoot().getSibling().getChild().getChild().getPriority());
        assertEquals(2, testHeap.getRoot().getSibling().getChild().getSibling().getPriority());
    }


    @Test
    public void insertNodeTest6() {

        BinomialHeap testHeap = new BinomialHeap();
        assertEquals(true, testHeap.isEmpty());

        BinomialNode testNode1 = new BinomialNode(6);
        BinomialNode testNode2 = new BinomialNode(5);
        BinomialNode testNode3 = new BinomialNode(4);
        BinomialNode testNode4 = new BinomialNode(3);
        BinomialNode testNode5 = new BinomialNode(2);
        BinomialNode testNode6 = new BinomialNode(1);

        testHeap.insert(testNode1);
        testHeap.insert(testNode2);
        testHeap.insert(testNode3);
        testHeap.insert(testNode4);
        testHeap.insert(testNode5);
        testHeap.insert(testNode6);

        assertEquals(false, testHeap.isEmpty());
        assertEquals(6, testHeap.size());
        assertEquals(1, testHeap.getRoot().getPriority());
        assertEquals(2, testHeap.getRoot().getChild().getPriority());
        assertEquals(3, testHeap.getRoot().getSibling().getPriority());
        assertEquals(5, testHeap.getRoot().getSibling().getChild().getPriority());
        assertEquals(6, testHeap.getRoot().getSibling().getChild().getChild().getPriority());
        assertEquals(4, testHeap.getRoot().getSibling().getChild().getSibling().getPriority());
    }


    @Test
    public void insertNodeTest7() {

        BinomialHeap testHeap = new BinomialHeap();
        assertEquals(true, testHeap.isEmpty());

        BinomialNode testNode1 = new BinomialNode(3);
        BinomialNode testNode2 = new BinomialNode(4);
        BinomialNode testNode3 = new BinomialNode(1);
        BinomialNode testNode4 = new BinomialNode(6);
        BinomialNode testNode5 = new BinomialNode(2);
        BinomialNode testNode6 = new BinomialNode(5);

        testHeap.insert(testNode1);
        testHeap.insert(testNode2);
        testHeap.insert(testNode3);
        testHeap.insert(testNode4);
        testHeap.insert(testNode5);
        testHeap.insert(testNode6);

        assertEquals(false, testHeap.isEmpty());
        assertEquals(6, testHeap.size());
        assertEquals(2, testHeap.getRoot().getPriority());
        assertEquals(5, testHeap.getRoot().getChild().getPriority());
        assertEquals(1, testHeap.getRoot().getSibling().getPriority());
        assertEquals(3, testHeap.getRoot().getSibling().getChild().getPriority());
        assertEquals(4, testHeap.getRoot().getSibling().getChild().getChild().getPriority());
        assertEquals(6, testHeap.getRoot().getSibling().getChild().getSibling().getPriority());
    }


    @Test
    public void insertNodeTest8() {

        BinomialHeap testHeap = new BinomialHeap();
        assertEquals(true, testHeap.isEmpty());

        BinomialNode testNode1 = new BinomialNode(3);
        BinomialNode testNode2 = new BinomialNode(4);
        BinomialNode testNode3 = new BinomialNode(1);
        BinomialNode testNode4 = new BinomialNode(6);
        BinomialNode testNode5 = new BinomialNode(2);
        BinomialNode testNode6 = new BinomialNode(5);

        testHeap.insert(testNode1);
        testHeap.insert(testNode2);
        testHeap.insert(testNode3);
        testHeap.insert(testNode4);
        testHeap.insert(testNode5);
        testHeap.insert(testNode6);

        assertEquals(false, testHeap.isEmpty());
        assertEquals(6, testHeap.size());
        assertEquals(2, testHeap.getRoot().getPriority());
        assertEquals(5, testHeap.getRoot().getChild().getPriority());
        assertEquals(1, testHeap.getRoot().getSibling().getPriority());
        assertEquals(3, testHeap.getRoot().getSibling().getChild().getPriority());
        assertEquals(4, testHeap.getRoot().getSibling().getChild().getChild().getPriority());
        assertEquals(6, testHeap.getRoot().getSibling().getChild().getSibling().getPriority());
    }


    @Test
    public void removeMinTest() {

        BinomialHeap testHeap = new BinomialHeap();
        assertEquals(true, testHeap.isEmpty());

        BinomialNode testNode1 = new BinomialNode(3);
        BinomialNode testNode2 = new BinomialNode(4);
        BinomialNode testNode3 = new BinomialNode(1);
        BinomialNode testNode4 = new BinomialNode(6);
        BinomialNode testNode5 = new BinomialNode(2);
        BinomialNode testNode6 = new BinomialNode(5);
        BinomialNode temp;

        testHeap.insert(testNode1);
        testHeap.insert(testNode2);
        testHeap.insert(testNode3);
        testHeap.insert(testNode4);
        testHeap.insert(testNode5);
        testHeap.insert(testNode6);

        assertEquals(false, testHeap.isEmpty());
        assertEquals(6, testHeap.size());
        temp = testHeap.removeMin();
        assertEquals(1, temp.getPriority());

        assertEquals(false, testHeap.isEmpty());
        assertEquals(5, testHeap.size());
        temp = testHeap.removeMin();
        assertEquals(2, temp.getPriority());

        assertEquals(false, testHeap.isEmpty());
        assertEquals(4, testHeap.size());
        temp = testHeap.removeMin();
        assertEquals(3, temp.getPriority());

        assertEquals(false, testHeap.isEmpty());
        assertEquals(3, testHeap.size());
        temp = testHeap.removeMin();
        assertEquals(4, temp.getPriority());

        assertEquals(false, testHeap.isEmpty());
        assertEquals(2, testHeap.size());
        temp = testHeap.removeMin();
        assertEquals(5, temp.getPriority());

        assertEquals(false, testHeap.isEmpty());
        assertEquals(1, testHeap.size());
        temp = testHeap.removeMin();
        assertEquals(6, temp.getPriority());
    }


    @Test
    public void minimumTest() {

        BinomialHeap testHeap = new BinomialHeap();
        assertEquals(true, testHeap.isEmpty());

        BinomialNode testNode1 = new BinomialNode(3);
        BinomialNode testNode2 = new BinomialNode(4);
        BinomialNode testNode3 = new BinomialNode(1);
        BinomialNode testNode4 = new BinomialNode(6);
        BinomialNode testNode5 = new BinomialNode(2);
        BinomialNode testNode6 = new BinomialNode(5);
        BinomialNode temp;

        testHeap.insert(testNode1);
        testHeap.insert(testNode2);
        testHeap.insert(testNode3);
        testHeap.insert(testNode4);
        testHeap.insert(testNode5);
        testHeap.insert(testNode6);

        assertEquals(false, testHeap.isEmpty());
        assertEquals(6, testHeap.size());
        assertEquals(1, testHeap.minimum().getPriority());
        temp = testHeap.removeMin();
        assertEquals(1, temp.getPriority());

        assertEquals(false, testHeap.isEmpty());
        assertEquals(5, testHeap.size());
        assertEquals(2, testHeap.minimum().getPriority());
        temp = testHeap.removeMin();
        assertEquals(2, temp.getPriority());

        assertEquals(false, testHeap.isEmpty());
        assertEquals(4, testHeap.size());
        assertEquals(3, testHeap.minimum().getPriority());
        temp = testHeap.removeMin();
        assertEquals(3, temp.getPriority());

        assertEquals(false, testHeap.isEmpty());
        assertEquals(3, testHeap.size());
        assertEquals(4, testHeap.minimum().getPriority());
        temp = testHeap.removeMin();
        assertEquals(4, temp.getPriority());

        assertEquals(false, testHeap.isEmpty());
        assertEquals(2, testHeap.size());
        assertEquals(5, testHeap.minimum().getPriority());
        temp = testHeap.removeMin();
        assertEquals(5, temp.getPriority());

        assertEquals(false, testHeap.isEmpty());
        assertEquals(1, testHeap.size());
        assertEquals(6, testHeap.minimum().getPriority());
        temp = testHeap.removeMin();
        assertEquals(6, temp.getPriority());
    }


    @Test
    public void linkTest() {

        BinomialNode testNode1 = new BinomialNode(1);
        BinomialNode testNode2 = new BinomialNode(2);
        BinomialHeap testHeap = new BinomialHeap();

        testHeap.link(testNode1, testNode2);

        assertEquals(1, testNode2.getChild().getPriority());
        assertEquals(2, testNode1.getParent().getPriority());
    }


    @Test
    public void unionTest() {

        BinomialNode testNode1 = new BinomialNode(1);
        BinomialNode testNode2 = new BinomialNode(4);
        BinomialHeap testHeap = new BinomialHeap();
        testHeap.insert(testNode1);
        testHeap.insert(testNode2);

        BinomialNode testNode3 = new BinomialNode(2);
        BinomialNode testNode4 = new BinomialNode(5);
        BinomialHeap testHeap2 = new BinomialHeap();
        testHeap2.insert(testNode3);
        testHeap2.insert(testNode4);

        BinomialHeap union = testHeap.union(testHeap, testHeap2);

        assertEquals(4, union.size());
        assertEquals(1, union.getRoot().getPriority());
        assertEquals(2, union.getRoot().getChild().getPriority());
        assertEquals(4, union.getRoot().getChild().getSibling().getPriority());
        assertEquals(5, union.getRoot().getChild().getChild().getPriority());


    }


    @Test
    public void deleteTest() {

        BinomialNode testNode1 = new BinomialNode(11);
        BinomialNode testNode2 = new BinomialNode(4);
        BinomialNode testNode3 = new BinomialNode(3);
        BinomialNode testNode4 = new BinomialNode(5);
        BinomialHeap testHeap = new BinomialHeap();
        testHeap.insert(testNode1);
        testHeap.insert(testNode2);
        testHeap.insert(testNode3);
        testHeap.insert(testNode4);

        assertEquals(3, testHeap.minimum().getPriority());
        testHeap.delete(testNode3);
        assertEquals(4, testHeap.minimum().getPriority());

    }

}
