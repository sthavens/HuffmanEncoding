package huffmanencoding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class FileInput{
    private InputStream inputStream;
    private int cursor;
    private boolean EOFReached;

    private void open(String fileName) {
        try {
            inputStream = new FileInputStream(fileName);
            getFirst();
        } catch (FileNotFoundException e) {
            System.out.println("The file specified could not be found.");
        }
    }

    private void getFirst() {
        try {
            cursor = inputStream.read();
            if (isEnd()) {
                throw new FileNotFoundException("This is a blank file.");
            }
        } catch (IOException e) {
           System.out.println("The first character could not be read: " + e);
        }
    }

    private boolean isEndLine() {
        return (char) cursor == '\n';
    }

    private boolean isEnd() {
        return cursor == -1;
    }

    private boolean isSpace() {
        return (char) cursor == '\s';
    }

    private boolean isTab() {
        return (char) cursor == '\t';
    }

    private boolean isDash() { //Handles the various types of dash character in ASCII
        return (char) cursor == '–' || (char) cursor == '—' || (char) cursor == '-';
    }

    public HeapNode<ResizeableArray<Character>> getLine() throws IOException, InputMismatchException{
        ResizeableArray<Character> outputCharacter = new ResizeableArray<>();
        if (isEnd()) {
            EOFReached = true;
        }
        if (isEndLine()) {
            getNext();
        }
        while(!isEnd() && !isEndLine() && !isDash()) {
            if (!isSpace() && !isTab()) {
                outputCharacter.append((char) cursor);
                getNext();
            }
        }
        if (!isDash() || outputCharacter.length != 1) {
            throw new InputMismatchException("The input string is malformed");
        }
        int priority = -1;
        String priorityString = "";
        while(!isEnd() && !isEndLine() && !isSpace()) {
            priorityString += cursor;
            getNext();
        }
        try {
            priority = Integer.parseInt(priorityString);
        } catch (NumberFormatException e){
            throw new InputMismatchException("The input string is malformed: " + e);
        }
        return new HeapNode<>(priority, outputCharacter);
    }

    private void getNext() {
        try {
            cursor = inputStream.read();
        } catch (IOException e) {
           System.out.println("The first character could not be read: " + e);
        }
    }
}
