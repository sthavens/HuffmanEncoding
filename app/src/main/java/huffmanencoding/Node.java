package huffmanencoding;

public interface Node<T> {

    public void setLeft(Node<T> leftNode);

    public void setRight(Node<T> rightNode);

    public Node<T> getLeft();

    public Node<T> getRight();

    public T getData();
}

