package huffmanencoding;

public class Tree<T> {
    private TreeNode<T> head;

    public Tree(TreeNode<T> head) {
        this.head = head;
    }

    public Node<T> getHead() {
        return this.head;
    }
}
