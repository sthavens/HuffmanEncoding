package huffmanencoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeNodeTest {
    TreeNode<Integer> testNode;

    @BeforeEach
    void setUp() {
        testNode = new TreeNode<Integer>(1);
    }

    @Test
    void setLeftThenGetLeftReturnsCorrectNode() {
        Node<Integer> leftNode = new TreeNode<>(2);
        testNode.setLeft(leftNode);
        assertEquals(2, testNode.getLeft().getData());
    }

    @Test
    void setRightThenGetRightReturnsCorrectNode() {
        Node<Integer> rightNode = new TreeNode<>(3);
        testNode.setRight(rightNode);
        assertEquals(3, testNode.getRight().getData());
    }

    @Test
    void nodeConstructorReturnsNode() {
        assertEquals(1, testNode.getData());
        assertNull(testNode.getLeft());
        assertNull(testNode.getRight());
    }

    @Test
    void checkLeafNodeWhenIsLeafNode() {
        assertTrue(testNode.isLeafNode());
    }

    @Test
    void checkLeafNodeWhenIsNotLeafNode() {
        TreeNode<Integer> placeHolderNode = new TreeNode<Integer>(null);
        assertFalse(placeHolderNode.isLeafNode());
    }

}
