package huffmanencoding;

public class MinHeap<T extends Length> {
    private ResizeableArray<HeapNode<T>> heap;

    

    public MinHeap() {
        this.heap = new ResizeableArray<>();
    }



    public void push(int priority, T data) {
        heap.append(new HeapNode<>(priority, data));
        percolateUp(heap.length - 1);
    }

    public HeapNode<T> pop() {
        HeapNode<T> temp;
        if (heap.length < 1) {
            throw new ArrayIndexOutOfBoundsException("There is nothing to pop.");
        } else if (heap.length == 1) {
            temp = heap.pop();
            return temp;
        }
        heap.swap(0, heap.length - 1);
        temp = heap.pop();
        percolateDown(0);
        return temp;
    }

    public void percolateUp(int index) {
        int cursor = index;
        while (hasParent(cursor) && heap.getItem(cursor).getPriority() < heap.getItem(getParent(cursor)).getPriority()){
            heap.swap(cursor, getParent(cursor));
            cursor = getParent(cursor);
        }
    }

    private boolean hasParent(int cursor) {
        return cursor > 0;
    }

    public void percolateDown(int index) {
        if (hasNoChildren(index)) {
            return;
        }

        if (hasOnlyLeftChild(index)) {
            if (heap.getItem(index).getPriority() > heap.getItem(getLeftChild(index)).getPriority()) {
                heap.swap(index, getLeftChild(index));
            }
            return;
        }
        
        if (heap.getItem(getLeftChild(index)).getPriority() <= heap.getItem(getRightChild(index)).getPriority()) {
            heap.swap(index, getLeftChild(index));
            percolateDown(getLeftChild(index));
        } else {
            heap.swap(index, getRightChild(index));
            percolateDown(getRightChild(index));
        }
    }

    public int getParent(int index) {
        if (index == 0) {
            return -1;
        }
        return (index - 1) / 2;
    }

    public int getLeftChild(int index) {
        return index * 2 + 1;
    }

    public int getRightChild(int index) {
        return index * 2 + 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChild(index) >= heap.length;
    }

    private boolean hasRightChild(int index) {
        return getRightChild(index) >= heap.length;
    }

    private boolean hasOnlyLeftChild(int index) {
        return getLeftChild(index) == heap.length - 1;
    }

    private boolean hasNoChildren(int index) {
        return hasLeftChild(index) && hasRightChild(index);
    }

    public int length() {
        return this.heap.length();
    }
    
}
