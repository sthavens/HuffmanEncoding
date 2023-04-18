package huffmanencoding;

public class TreeNode<T> implements Node<T> {
    T data;
    Node<T> left;
    Node<T> right;

    @Override
    public T getData() {
        return this.data;
    }

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public Node<T> getLeft() {
        return this.left;
    }

    @Override
    public Node<T> getRight() {
        return this.right;
    }

    @Override
    public void setLeft(Node<T> leftNode) {
        this.left = leftNode;
    }

    @Override
    public void setRight(Node<T> rightNode) {
        this.right = rightNode;
    }

    public boolean isLeafNode() {
        return getLeft() == null && getRight() == null;
    }

}
