package huffmanencoding;

public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T data) {
        this.data = data;
    }

    public void setLeft(Node<T> leftNode) {
        this.left = leftNode;
    }

    public void setRight(Node<T> rightNode) {
        this.right = rightNode;
    }

    public Node<T> getLeft() {
        return this.left;
    }

    public Node<T> getRight() {
        return this.right;
    }

    public T getData() {
        return this.data;
    }
}

