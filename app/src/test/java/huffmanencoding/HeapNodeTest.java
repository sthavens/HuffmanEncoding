package huffmanencoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HeapNodeTest {
    HeapNode<ResizeableArray<Character>> testNode;
    @Test
    void testGetData() {
        assertEquals("TEST", testNode.getData().toString());
    }

    @Test
    void testGetHeadLength() {
        assertEquals(4, testNode.getHeadLength());
    }

    @Test
    void testGetPriority() {
        assertEquals(1, testNode.getPriority());
    }

    @Test
    void testIsSingletonIfNotSingleton() {
        assertFalse(testNode.isSingleton());
    }

    @Test
    void testIsSingletonIfSingleton() {
        HeapNode<ResizeableArray<Character>> singletonNode = new HeapNode<ResizeableArray<Character>>(0, new ResizeableArray<>(new Character[]{'A'}));
        assertTrue(singletonNode.isSingleton());
    }

    @BeforeEach
    void setUp() {
        testNode = new HeapNode<ResizeableArray<Character>>(1, new ResizeableArray<>(new Character[]{'T', 'E', 'S', 'T'}));
    }

    @Test
    void testGetLeft() {
        HeapNode<ResizeableArray<Character>> testLeftNode = new HeapNode<ResizeableArray<Character>>(0, new ResizeableArray<>(new Character[]{'A'}));
        testNode.setLeft(testLeftNode);
        assertEquals(testLeftNode, testNode.getLeft());
    }

    @Test
    void testGetRight() {
        HeapNode<ResizeableArray<Character>> testRightNode = new HeapNode<ResizeableArray<Character>>(0, new ResizeableArray<>(new Character[]{'A'}));
        testNode.setRight(testRightNode);
        assertEquals(testRightNode, testNode.getRight());
    }
}
