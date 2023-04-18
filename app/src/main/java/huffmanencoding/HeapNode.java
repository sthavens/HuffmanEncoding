package huffmanencoding;

public class HeapNode<T extends Length> implements Priority, Node{

    private int priority;
    private T data;
    private HeapNode<T> left;
    private HeapNode<T> right;

    

    public HeapNode(int priority, T data) {
        this.priority = priority;
        this.data = data;
    }

    public T getData() {
        return this.data;
    }


    public int getPriority() {
        return this.priority;
    }

    public int getHeadLength() {
        if (data == null) {
            throw new NullPointerException("This node has a null head pointer. Cannot return head length.");
        }
        return this.data.length();
    }

    public boolean isSingleton() {
        return getHeadLength() == 1;
    }

    @Override
    public void setLeft(Node leftNode) {
        this.left =(HeapNode<T>) leftNode;
    }

    @Override
    public void setRight(Node rightNode) {
        this.right = (HeapNode<T>) rightNode;
    }

    @Override
    public Node getLeft() {
        return this.left;
    }

    @Override
    public Node getRight() {
        return this.right;
    }
    
}
