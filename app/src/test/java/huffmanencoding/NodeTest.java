package huffmanencoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeTest {
    Node<Integer> testNode;

    @BeforeEach
    void setUp() {
        testNode = new Node<Integer>(1);
    }

    @Test
    void setLeftThenGetLeftReturnsCorrectNode() {
        Node<Integer> leftNode = new Node<>(2);
        testNode.setLeft(leftNode);
        assertEquals(2, testNode.getLeft().getData());
    }

    @Test
    void setRightThenGetRightReturnsCorrectNode() {
        Node<Integer> rightNode = new Node<>(3);
        testNode.setRight(rightNode);
        assertEquals(3, testNode.getRight().getData());
    }

    @Test
    void nodeConstructorReturnsNode() {
        assertEquals(1, testNode.getData());
        assertNull(testNode.getLeft());
        assertNull(testNode.getRight());
    }

}
