package huffmanencoding;

public class Tree<T> {
    private Node<T> head;

    public Tree(Node<T> head) {
        this.head = head;
    }

    public Node<T> getHead() {
        return this.head;
    }
}
