package huffmanencoding;

import java.util.Arrays;

public class ResizeableArray<T> implements Length{
    T[] data;
    int length;
    int provisionedSize;

    public ResizeableArray() {
        this.data = (T[]) new Object[1];
        length = 0;
        provisionedSize = 1;
    }

    public ResizeableArray(T[] data) {
        this.data = data;
        this.length = data.length;
        this.provisionedSize = data.length;
    }

    public int length() {
        return length;
    }

    public T getItem(int index) {
        if (index > length) {
            throw new ArrayIndexOutOfBoundsException("The requested item is out of bounds.");
        }
        return data[index];
    }

    private void setItem(int index, T itemData) {
        if (index > length) {
            throw new ArrayIndexOutOfBoundsException(
                    "This character is outside of the bounds of the array.");
        } else if (index == length) {
            append(itemData);
        } else {
            data[index] = itemData;
        }
    }

    public void append(T itemData) {
        if (length == provisionedSize) {
            resize();
        }
        data[length++] = itemData;
    }

    public void swap(int fromIndex, int toIndex) {
        T temp = data[fromIndex];
        setItem(fromIndex, data[toIndex]);
        setItem(toIndex, temp);
    }

    private void resize() {
        T[] tempData = (T[]) new Object[provisionedSize * 2];
        for (int i = 0; i < provisionedSize; i++) {
            tempData[i] = data[i];
        }
        data = tempData;
        provisionedSize *= 2;
    }

    public void insert(T item) {
        if (length >= provisionedSize) {
            resize();
        }
        data[length++] = item;
    }

    public T pop() {
        return data[--length];
    }

    public T[] returnNormalArray() {
        T[] temp = (T[]) new Object[length];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        return temp;
    }

    @Override
    public String toString() {
        String returnString = "";
        for(T item: data) {
            returnString += item.toString();
        }
        return returnString;
    }

    

}
