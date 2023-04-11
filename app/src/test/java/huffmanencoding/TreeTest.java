package huffmanencoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeTest {
    Tree<Integer> testTree;

    @BeforeEach
    void setUp() {
        Node<Integer> testHeadNode = new Node<>(1);
        testTree = new Tree<>(testHeadNode);
    }

    @Test
    void testGetHead() {
        assertEquals(1, testTree.getHead().getData());
    }
}
