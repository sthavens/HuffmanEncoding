package huffmanencoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResizeableArrayTest {
    ResizeableArray<Integer> testArray;

    @BeforeEach
    void setUp() {
        testArray = new ResizeableArray<>();
    }

    @Test
    void constructorCreatesEmptyArray() {
        assertNull(testArray.getItem(0));
        assertEquals(0, testArray.length());
        assertEquals(1, testArray.provisionedSize);
    }

    @Test
    void testAppend() {
        addItems(1);
        assertEquals(1, testArray.getItem(0));
        assertEquals(1, testArray.provisionedSize);
    }

    private void addItems(int itemsToAdd) {
        for (int i = 1; i <= itemsToAdd; i++){
            testArray.append(i);
        }
    }

    @Test
    void testSwap() {
        addItems(3);
        assertEquals(1, testArray.getItem(0));
        assertEquals(3, testArray.getItem(2));
        testArray.swap(0, 2);
        assertEquals(3, testArray.getItem(0));
        assertEquals(1, testArray.getItem(2));
    }

    @Test
    void testResize() {
        assertEquals(1, testArray.provisionedSize);
        addItems(9);
        assertEquals(16, testArray.provisionedSize);
    }
}
